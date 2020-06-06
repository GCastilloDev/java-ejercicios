package testpassword;

import java.util.Random;

/**
 *
 * @author Estudiante
 */
public class Password {

    private int longitud;
    private String contraseña;

    public Password() {
        this.longitud = 8;
    }

    public Password(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public boolean esFuerte(String contraseña) {
        
        int mayusculas = Password.contarCaracteres(65, 91, contraseña);
        int minuscula = Password.contarCaracteres(97, 123, contraseña);
        int numero = Password.contarCaracteres(48, 58, contraseña);
        
        return mayusculas > 2 && minuscula > 1 && numero > 5;

    }

    public  String generarPassword(int longitud) {

        int minimo = 48;
        int maximo = 122;
        int letra = 0;
        int i = 1;
        char ascii = ' ';
        String password = "";
        
        do {

            Random r = new Random();
            letra = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);

            if (letra == 58 || letra == 59 || letra == 60 || letra == 61 || letra == 62 || letra == 63 || letra == 64
                    || letra == 91 || letra == 92 || letra == 93 || letra == 94 || letra == 95 || letra == 96) {
                i = i;
            } else {
                ascii = (char) letra;
                password += Character.toString(ascii);
                i++;
            }

        } while (i <= longitud);

        return password;
    }

    /**
     * Cuenta através los carácteres que se encuentran en el rango de máximo y mínimo, que representan los 
     * rangos de código ascii, rangos para mayúsculas: 65-91. Rango para mínusculas: 97-123. Rango para
     * números: 48-58.
     * @param minimo
     * @param maximo
     * @param contraseña
     * @return 
     */
    
    public static int contarCaracteres(int minimo, int maximo, String contraseña) {
        int contador = 0;
        
        for (int i = minimo; i < maximo; i++) {
            for (int j = 0; j < contraseña.length(); j++) {
                int caracter = (int) contraseña.charAt(j);
                if (caracter == i) {
                    contador++;
                }
            }
        }
        return contador;
    }

}
