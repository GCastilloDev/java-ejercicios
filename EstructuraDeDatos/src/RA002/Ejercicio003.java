package RA002;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio003 {

    public static void main(String[] args) {

//        int arreglo[][] = new int [4][4];
        int arreglo [][] = { {2,2,2,2},
                                     {4,4,4,4},
                                     {3,3,3,3},
                                     {4,4,4,4} };
        imprimir(arreglo);
        System.out.println("\nSuma diagonal invertida: " + sumar(arreglo));
        
    }
    
    static void imprimir(int arreglo[][]){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.print(arreglo[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    
    static int sumar(int arreglo[][]){
        
        int suma = 0;
        int elemento = arreglo.length - 1;
        
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i][elemento];
            elemento--;
        }
        return suma;
    }
}
