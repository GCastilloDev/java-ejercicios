package Ejercicio001;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio002 {

    //Busqueda en arreglo
    public static void main(String[] args) {

        int arreglo[] = llenarArreglo();
        Scanner n = new Scanner(System.in);

        System.out.println("Ingresa un primero número entero:");
        int numUno = n.nextInt();

        System.out.println("Ingresa un segundo número entero:");
        int numDos = n.nextInt();

        busquedaArreglo(arreglo, numUno, numDos);
    }

    public static void busquedaArreglo(int arreglo[], int numUno, int numDos) {
        boolean numeroUno = false;
        boolean numeroDos = false;

        for (int i = 0; i < arreglo.length; i++) {

            if (arreglo[i] == numUno) {
                numeroUno = true;
            }

            if (arreglo[i] == numDos) {
                numeroDos = true;
            }
        }
        
        determinarBusqueda(numeroUno, numeroDos, numUno, numDos);
    }

    public static void determinarBusqueda(boolean numeroUno, boolean numeroDos, int numUno, int numDos) {

        if (numeroUno == true && numeroDos == true) {
            System.out.println("Los dos números capturados se encuentran en el arreglo");
        } else if (numeroUno == true) {
            System.out.println("El número " + numUno + " se encuentra en el arreglo");
        } else if (numeroDos == true) {
            System.out.println("El número " + numDos + " se encuentra en el arreglo");
        }else{
            System.out.println("Ninguno de los dos números se encuentran en el arreglo");
        }

    }

    public static int[] llenarArreglo() {
        int arreglo[] = new int[5];

        Scanner n = new Scanner(System.in);

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingrese el número: ");
            arreglo[i] = n.nextInt();
        }

        return arreglo;
    }
}
