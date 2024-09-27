import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileManager {


    public static Path crearArch(String nomArch) {
    String ruta = "src/" + nomArch+".txt";
        Path destPath = Path.of(ruta); //archivocifrado.txt");


       // Validator.borrarArch(String.valueOf(destPath));

        try {
            Files.createFile(destPath);
            System.out.println("Archivo creado con exito");
            return destPath;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("el archivo no pudo ser creado");
        return null;
    }


    public static String readFile(String filePath) throws Exception {

        Path rutaEntrada = Paths.get(filePath);
        try (FileChannel canal = FileChannel.open(rutaEntrada, StandardOpenOption.READ)) {
            if (canal.size() > Integer.MAX_VALUE) {
                throw new Exception("El archivo es muy grande");
            }
            ByteBuffer byteBufferLeer = ByteBuffer.allocate((int) canal.size());
            int bytesLeidos;
            while ((bytesLeidos = canal.read(byteBufferLeer)) != -1) {
                byteBufferLeer.flip();
                byte[] bufferBytesLeer = new byte[bytesLeidos];//creamos un array con el tamaño de los bytes leidos
                byteBufferLeer.get(bufferBytesLeer);
                String texto = new String(bufferBytesLeer);
                //System.out.println(new String(bufferBytesLeer));

                // convertir mensaje
                byteBufferLeer.clear();
                return texto;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void writeFile(String content, String filePath) throws Exception {
        // Logic for writing a file


        if (Paths.get(filePath).toFile().isFile()){
            Validator.borrarArch(filePath);
        }
        Path destPath = crearArch(filePath);
        try (FileChannel canalSalida = FileChannel.open(destPath, StandardOpenOption.WRITE)) {
            ByteBuffer byteBufferEscribir = ByteBuffer.wrap(content.getBytes());
            canalSalida.write(byteBufferEscribir);
            byteBufferEscribir.clear();
            System.out.println("Se cifro el archivo");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}