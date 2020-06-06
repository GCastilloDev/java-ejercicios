package NivelAvanzado;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Yuki {

    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);

        System.out.print("Número de casos: ");
        int casos = n.nextInt();
        int numerosYika[] = new int[casos];

        for (int i = 0; i < numerosYika.length; i++) {
            System.out.print("Número propuesto por Yika [" + (i + 1) + "]: ");
            numerosYika[i] = n.nextInt();
        }

        for (int i = 0; i < numerosYika.length; i++) {
            int aux = 0;
            int auxNumA = 0;
            int auxNumB = 0;            
            for (int j = 1; j <= numerosYika[i] / 2; j++) {
                int numA = j;
                int numB = numerosYika[i] - j;
                int binarioA = convertirBinario(numA);
                int binarioB = convertirBinario(numB);
                int unosA = contarUnos(binarioA);
                int unosB = contarUnos(binarioB);
                int suma = unosA + unosB;
                if (aux < suma) {
                    aux = suma;
                    auxNumA = numA;
                    auxNumB = numB;
                }
            }
            System.out.println("");
            System.out.println("========== CASO " + (i+1) + "==========");
            System.out.println("Yuki escoge " + auxNumA + " y " + auxNumB);
            System.out.println(auxNumA + " en binario es " + convertirBinario(auxNumA));
            System.out.println(auxNumB + " en binario es " + convertirBinario(auxNumB));
            System.out.println("Mayor cantidad de avellanas: " + aux);
            System.out.println("");
        }

    }

    static int convertirBinario(int numero) {
        String num = "";
        String auxiliar = "";

        while (numero > 0) {
            num += numero % 2;
            numero = numero / 2;
        }
        for (int i = num.length() - 1; i >= 0; i--) {
            auxiliar += num.charAt(i);
        }
        return Integer.parseInt(auxiliar);
    }

    static int contarUnos(int numero) {
        int contador = 0;
        String num = String.valueOf(numero);

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '1') {
                contador++;
            }
        }
        return contador;
    }
}
