package Ejercicio001;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio001 {

    public static void main(String[] args) {
        //Número perfecto
        Scanner n = new Scanner(System.in);
        
        System.out.print("Ingresa un número: ");
        int numero = n.nextInt();
        
        System.out.println("¿El " + numero + " es un número perfecto? " + numeroPerfecto(numero));
    }

    public static boolean numeroPerfecto(int numero) {
        int suma = 0;

        for (int i = 1; i < numero; i++) {

            if (numero % i == 0) {
                suma += i;
                //System.out.println("numero: " + i + " suma: " + suma);
            }

            if (suma == numero) {
                return true;
            }
        }

        return false;

    }

}
