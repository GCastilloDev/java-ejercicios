package NivelAvanzado;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class ContarPalabras {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);

        System.out.print("Número de casos: ");
        int casos = n.nextInt();
        n.nextLine();
        int palabrasEncontradas[] = new int[casos];

        for (int i = 0; i < casos; i++) {
            System.out.print("Ingresa frase " + (i + 1) + ": ");
            String frase = n.nextLine();
            palabrasEncontradas[i] = encontrarPalabras(frase);
        }

        for (int i = 0; i < palabrasEncontradas.length; i++) {
            System.out.println("Caso #" + (i + 1) + ": " + formatoSalida(palabrasEncontradas[i]));
        }

    }

    static int encontrarPalabras(String frase) {
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'h' || frase.charAt(i) == 'H') {
                for (int j = i + 1; j < frase.length(); j++) {
                    if (frase.charAt(j) == 'o' || frase.charAt(i) == 'O') {
                        for (int k = j + 1; k < frase.length(); k++) {
                            if (frase.charAt(k) == 'l' || frase.charAt(i) == 'L') {
                                for (int l = k + 1; l < frase.length(); l++) {
                                    if (frase.charAt(l) == 'a' || frase.charAt(i) == 'A') {
                                        contador++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return contador;
    }

    static String formatoSalida(int numero) {
        String num = String.valueOf(numero);
        String auxiliar = "";
        if (num.length() < 4) {
            for (int i = 0; i < 4 - num.length(); i++) {
                auxiliar += "0";
            }
            auxiliar += num;
        }
        if (num.length() > 4) {
            for (int i = 0; i < 4; i++) {
                auxiliar += num.charAt(i);
            }
        }
        if (num.length() == 4) {
            auxiliar = num;
        }
        return auxiliar;
    }
}