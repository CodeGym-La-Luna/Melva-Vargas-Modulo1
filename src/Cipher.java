public class Cipher {

    private static final String ALFABETO = generaAlfabeto();


    public static String encrypt(String text, int clave) {
        // Encryption logic

        if (Validator.claveCorrecta(clave)) {
            StringBuilder ciphertext = new StringBuilder();
            char[] toCipher = text.toCharArray();
            int longAlfabeto = ALFABETO.length();
            for (char c : toCipher) {
                int indice = ALFABETO.indexOf(c);
                if (ALFABETO.contains(String.valueOf(c))) {
                    int newPos = (indice + clave) % longAlfabeto;
                    ciphertext.append(ALFABETO.charAt(newPos));
                } else {
                    ciphertext.append(c);
                }
            }
            return ciphertext.toString();
        }
    return null;
    }

    public static String decrypt(String encryptedText, int clave) {
        // Decryption logic
        return encrypt(encryptedText, ALFABETO.length()-clave);
    }

    public static String generaAlfabeto(){
           String caracteres="";
        for (char c =  ' ';c <= '~';c++ ){
            caracteres = caracteres+(char)c;
        }
        return caracteres;
    }
}