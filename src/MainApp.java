
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainApp {
    public static int clave;


    public static void main(String[] args) throws Exception {

        //Instanciamos los metodos
       // Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();

        //Menu de la aplicación
        Scanner consola = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while(!salir){

            System.out.println("\n\t-- Proyecto Final Modulo 1-Cifrado Cesar --");

            System.out.println("1.- Cifrar un Texto");
            System.out.println("2.- Descifrar un texto Cifrado");
            System.out.println("3.- Fuerza Bruta");
            System.out.println("4.- Analisis Estadistico");
            System.out.println("5.- Salir");

            try{
                System.out.println("Seleccione una opción: ");
                opcion = consola.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("CIFRADO DE TEXTO");

                        System.out.println("Introduzca la ruta y el nombre del archivo origen");
                        consola.nextLine();
                        String filePathOrig  = consola.nextLine();
                        if (Paths.get(filePathOrig).toFile().isFile()) {
                              System.out.println("Introduzca la clave para el cifrado");
                            clave = consola.nextInt();
                                if (Validator.claveCorrecta(clave)){
                                    System.out.println("Introducir solo el nombre del archivo cifrado");
                                    consola.nextLine();
                                    String archDestino = consola.nextLine();

                                    String texto = fileManager.readFile(String.valueOf(filePathOrig)); //Lee el archivo original

                                    String textoCifrado = Cipher.encrypt(texto, clave); //Llama al metodo de encriptación

                                    fileManager.writeFile(textoCifrado, archDestino); //Escribe el archivo cifrado
                                }

                        }else {
                            System.out.println("Este archivo no existe");
                            salir=true;}
                        break;

                    case 2:
                        System.out.println("DECIFRADO DE TEXTO");
                        System.out.println("Introducir nombre de archivo a decifrar");
                        consola.nextLine();
                        String archCifrado = consola.nextLine();
                        if (Paths.get(archCifrado).toFile().isFile()) {
                            System.out.println("Introduzca la clave para el decifrado");
                            clave = consola.nextInt();
                            if (Validator.claveCorrecta(clave)){

                                String texto2 = fileManager.readFile(archCifrado);
                                //System.out.println(texto2);
                                System.out.println("Introducir solo el nombre del archivo Decifrado");
                                consola.nextLine();
                                String archDecifrado = consola.nextLine();
                                String textoDecifrado = Cipher.decrypt(texto2, clave);
                                //System.out.println(textoDecifrado);
                                fileManager.writeFile(textoDecifrado,archDecifrado);
                            }
                        }else{
                            System.out.println("Este archivo no existe");
                            salir=true;}
                        break;

                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        salir=true;
                        break;
                    default:
                        System.out.println("Las opciones son entre 1 y 5");

                }
            }
            catch(IOException e){
                System.out.println("Debes seleccionar un número de opción");
                consola.next();
            }
        }

        System.out.println("Gracias por utilizar el programa integrador, hasta luego... ");

    }
}
