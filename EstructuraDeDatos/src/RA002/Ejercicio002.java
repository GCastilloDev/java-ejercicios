package RA002;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio002 {

    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);

//        String paisesCiudad[][] = new String[4][4];
        String paisesCiudad[][] = {{"Argentina", "Buenos Aires", "Córdoba", "La Plata"},
        {"España", "Madrid", "Lugo", "Sevilla"},
        {"Francia", "París", "Niza", "Lyon"},
        {"Italia", "Roma", "Nápoles", "Sicilia"}};
//
//        ingresarPaises(paisesCiudad, n);
//        ingresarCiudades(paisesCiudad, n);
        imprimirMatriz(paisesCiudad);
    }

    static void ingresarPaises(String matriz[][], Scanner n) {

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Ingresa el nombre del país[" + (i + 1) + "]: ");
            matriz[i][0] = n.nextLine();
        }
    }

    static void ingresarCiudades(String matriz[][], Scanner n) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 1; j < matriz[i].length; j++) {
                System.out.print("Ingresa la ciudad [" + j + "] del país " + matriz[i][0] + ": ");
                matriz[i][j] = n.nextLine();
            }
        }
    }

    static void imprimirMatriz(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (j == 0) {
                    System.out.print("País: ");

                }
                if (j == 1) {
                    System.out.print("Ciudades: ");
                }

                if (j > 1) {
                    System.out.print(matriz[i][j] + "\t\t");
                } else if (i >= 2 && j == 1) {
                    System.out.print(matriz[i][j] + "\t\t\t");
                } else {
                    System.out.print(matriz[i][j] + "\t\t");
                }

            }
            System.out.println("");
        }
    }

}
