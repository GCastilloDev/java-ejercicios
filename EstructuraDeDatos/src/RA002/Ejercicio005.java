package RA002;

import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio005 {
    
    public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        
        System.out.print("Ingrese las filas de la primer matriz: ");
        int filasA = n.nextInt();
        System.out.print("Ingrese las columnas de la primer matriz: ");
        int columnasA = n.nextInt();
          System.out.print("Ingrese las filas de la segunda matriz: ");
        int filasB = n.nextInt();
        System.out.print("Ingrese las columnas de la segunda matriz: ");
        int columnasB = n.nextInt();
         
        int primerMatriz[][] = new int [filasA][columnasA];
        int segundaMatriz[][] = new int[filasB][columnasB];
//        int primerMatriz[][] = { {1,3,2}, {1,0,0}, {1,2,2} };
//        int segundaMatriz[][] = { {1,0,5}, {7,5,0}, {2,1,1} };
//        
//        int resultadoSuma[][] = sumar(primerMatriz, segundaMatriz);
//        imprimir(resultadoSuma);
        
        if(sonIguales(filasA, filasB) == true && sonIguales(columnasA, columnasB) == true){
            System.out.println("LLenar primera matriz: ");
            primerMatriz = llenarMatriz(filasA, columnasA, n);
            System.out.println("");
            System.out.println("Llenar segunda matriz: ");
            segundaMatriz = llenarMatriz(filasB, columnasB, n);
            System.out.println("");
            System.out.println("Resultado de la suma de las dos matrices:");
            int resultadoSuma[][] = sumar(primerMatriz, segundaMatriz);
            imprimir(resultadoSuma);
           }else{
            System.out.println("\"No se pueden sumar\"");
            System.out.println("Para poder sumar las matrices deben de tener el mismo tamaño.");
        }
    }
    
    static boolean sonIguales(int valorA, int valorB){
               return valorA==valorB;
    }
    
    static int[][] sumar(int primerMatriz[][],  int segundaMatriz[][]){
        int resultadoSuma[][] = new int[primerMatriz.length][primerMatriz[0].length];
        
        for (int i = 0; i < primerMatriz.length; i++) {
            for (int j = 0; j < primerMatriz[i].length; j++) {
                resultadoSuma[i][j] = primerMatriz[i][j] + segundaMatriz[i][j];
            }
            
        }
        return resultadoSuma;
    }
    
    static int[][] llenarMatriz(int filas, int columnas, Scanner n){
        int matriz[][] = new int[filas][columnas];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Ingresa el valor de la posición [" + (i+1) +"][" + (j+1) +"]");
                matriz[i][j]  = n.nextInt();
            }
        }
        return  matriz;
    }
    
    static void imprimir(int matriz[][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
