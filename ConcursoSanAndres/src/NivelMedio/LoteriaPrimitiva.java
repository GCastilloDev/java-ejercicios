package NivelMedio;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class LoteriaPrimitiva {

    public static void main(String[] args) {

        int numerosElegidos[] = new int[6];
        int combinacionGanadora[] = new int[6];

        System.out.println("Elige 6 números entre el 1 y el 49.");

        Scanner n = new Scanner(System.in);

        String elegidos = "Números Elegidos: ";
        String ganadora = "Combinación ganadora: ";
        char continuar = ' ';

        do {
            //Pedir número a usuario y generar números aleatorios
            for (int i = 0; i < numerosElegidos.length; i++) {

                int numeroIngresado = 0;

                do {
                    System.out.print("Elige el número " + (i + 1) + ": ");
                    numeroIngresado = n.nextInt();
                } while (hayRepetidos(numerosElegidos, i, numeroIngresado) || numeroIngresado > 49 || numeroIngresado < 1);
                numerosElegidos[i] = numeroIngresado;
                combinacionGanadora[i] = generarNumero();
            }
            
            //Ordenar arreglo de menor a mayor
            Arrays.sort(combinacionGanadora);
            
            //Acumular números para imprimirlos
            for (int i = 0; i < combinacionGanadora.length; i++) {
                elegidos += numerosElegidos[i] + " ";
                ganadora += combinacionGanadora[i] + " ";
            }

            int numsAcertados = numerosAcertados(numerosElegidos, combinacionGanadora);

            System.out.println(elegidos);
            System.out.println(ganadora);
            elegidos = "Números Elegidos: ";
            ganadora = "Combinación ganadora: ";
            System.out.print("Has acertado: " + numsAcertados + " números");
            System.out.print("\nQuieres probar otra vez? (S/N): ");
            continuar = n.next().charAt(0);

        } while (continuar == 's' || continuar == 'S');

    }

    public static int generarNumero() {
        int menor = 1;
        int mayor = 49;
        return (int) Math.floor(Math.random() * (mayor - menor + 1) + menor);
    }

    public static boolean hayRepetidos(int[] arreglo, int posicion, int numeroIngresado) {
        if (posicion == 0) {
            return false;
        } else {
            for (int i = 0; i < posicion; i++) {
                if (numeroIngresado == arreglo[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int numerosAcertados(int numerosElegidos[], int combinacionGanadora[]) {
        int acertados = 0;

        for (int i = 0; i < combinacionGanadora.length; i++) {
            for (int j = 0; j < combinacionGanadora.length; j++) {
                if (numerosElegidos[i] == combinacionGanadora[j]) {
                    acertados++;
                }
            }
        }

        return acertados;
    }
}
