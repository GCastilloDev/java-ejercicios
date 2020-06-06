package NivelAvanzado;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class CodigoMorse {

    public static void main(String[] args) {
        String codigoMorse[] = {".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."};

        Scanner n = new Scanner(System.in);

        System.out.print("Ingresa la palabra: ");
        String palabra = n.next().toLowerCase();

        int contador = 0;
        String claveMorse = convertirAMorse(palabra, codigoMorse);
        int posicion = 0;
        String frase = "";
        char auxiliar = ' ';

        for (int i = 2; i < 5; i++) {
            if (claveMorse.length() % i == 0) {
                for (int j = 0; j < claveMorse.length(); j = j + i) {
                    System.out.println(j);
                    for (int k = 97; k < 123; k++) {
                        auxiliar = (char) k;
                        frase += auxiliar;
                        for (int l = 97; l < 123; l++) {
                            auxiliar = (char) k;
                            frase += auxiliar;
                        }
                    }
                }
            }
        }

        System.out.println(frase);
        System.out.println(contador);
        System.out.println(claveMorse);
        System.out.println(claveMorse.length());
    }

    static String convertirAMorse(String palabra, String[] codigoMorse) {
        int posicion = 0;
        String claveMorse = "";
        for (int i = 0; i < palabra.length(); i++) {
            posicion = palabra.charAt(i) - 97;
            claveMorse += codigoMorse[posicion];
        }
        return claveMorse;
    }

    static boolean esProhibida(String palabra) {
        String morseProhibidas[] = {"..--", ".-.-", "---.", "----"};

        for (int i = 0; i < morseProhibidas.length; i++) {
            if (palabra.equalsIgnoreCase(morseProhibidas[i])) {
                System.out.println("palabra " + palabra + " morse " + morseProhibidas[i]);
                return true;
            }
        }
        return false;
    }

    static boolean esIgual(String palabra, String codigoMorse[]) {
        for (int i = 0; i < codigoMorse.length; i++) {
            if (palabra.equalsIgnoreCase(codigoMorse[i])) {
                return true;
            }
        }
        return false;
    }

    static String dameMorse(String palabra, int inicio, int tamaño) {
        String res = String.valueOf(palabra.charAt(inicio));

        for (int i = inicio + 1; i < tamaño; i++) {
            System.out.println(res);
            res += String.valueOf(palabra.charAt(i));
        }
        return res;
    }

    static String obtenerCodigoMorse(String palabra, int inicio, int tamaño) {
        String codigoMorse = "";

        for (int i = inicio; codigoMorse.length() < tamaño; i++) {
            codigoMorse += String.valueOf(palabra.charAt(i));
        }

        return codigoMorse;
    }
}