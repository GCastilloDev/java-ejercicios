package RA002;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
//Escriba un programa que contenga un método que acepte como parámetro una lista
//de números enteros mayores a cero, pudiendo contener elementos duplicados. Este
//método debe sustituir cada valor repetido por un cero, para terminar realiza un
//método que muestre el array modificado.
public class Ejercicio007 {

    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);
        List<Integer> numeros = llenarLista(n);
        System.out.println("=============<LISTA INGRESADA>=============");
        imprimirLista(numeros);
        
        if(encontrarRepetidos(numeros) == true){
            System.out.println("=============<LISTA SUSTITUIDA>=============");
            sustituirRepetidos(numeros);
            imprimirLista(numeros);
        }else{
            System.out.println("No hay números repetidos en la lista.");
        }

    }

    static List<Integer> llenarLista(Scanner n) {

        List<Integer> numeros = new ArrayList();

        boolean continuar = true;
        int contador = 1;

        do {
            System.out.print("Ingrese número en posición [" + contador + "]: ");
            int numero = n.nextInt();

            if (numero > 0) {
                numeros.add(numero);
                contador++;
            } else {
                continuar = false;
            }
        } while (continuar == true);

        return numeros;
    }

    static void imprimirLista(List<Integer> numeros) {
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println("Posición " + (i + 1) + ": " + numeros.get(i));
        }
    }

    static boolean encontrarRepetidos(List<Integer> numeros) {

        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                if (numeros.get(i) == numeros.get(j)) {
                    return true;
                }
            }
        }

        return false;
    }

    static List<Integer> sustituirRepetidos(List<Integer> numeros) {

        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                if (numeros.get(i) == numeros.get(j)) {
                    numeros.set(j, 0);
                }
            }
        }

        return numeros;
    }
}
