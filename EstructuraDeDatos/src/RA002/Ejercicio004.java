package RA002;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio004 {

    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);
        System.out.print("¿Cuantos estudiantes ingresará? ");
        int filas = n.nextInt();

        String estudiantes[][] = new String[filas][2];

        registrar(estudiantes, n);
        System.out.println("Lista de estudiantes:");
        System.out.println(lista(estudiantes));

    }

    static void registrar(String arreglo[][], Scanner n) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (j == 0) {
                    System.out.print("Ingresa el código del estudiante[" + (i + 1) + "]: ");
                    arreglo[i][j] = n.next();
                } else {
                    System.out.print("Ingresa el nombre del estudiante[" + (i + 1) + "]: ");
                    arreglo[i][j] = n.next();
                }
            }
            System.out.println("");
        }
    }

    static String lista(String arreglo[][]){
        String lista = "";
        
        for (int i = 0; i < arreglo.length; i++) {
            lista += (i+1) + ".- " + arreglo[i][1] + "\n";
        }
        
        return lista;
    }
}
