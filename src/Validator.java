import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {

    public boolean isFileExists(String filePath) {

        // Check if the file exists

        return false;
    }

    public static boolean claveCorrecta(int clave){
        if (clave>=1){
            return true;
        }
        System.out.println("Clave incorrecta!! Debe ingresar un nro mayor o igual a 1");
        return false;
    }
    public static void borrarArch(String filePath) {
        Path ruta = Paths.get(filePath);
        try {
            Files.delete(ruta);
        } catch (IOException e) {
            System.out.println("Error al eliminar archivo");
        }
    }

}
