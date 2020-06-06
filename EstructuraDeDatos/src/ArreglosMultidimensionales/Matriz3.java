package ArreglosMultidimensionales;
import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Matriz3 {

    public static int[][] llenarMatriz(Scanner objeto){
        
        int matriz [][] = new int[3][3];         
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("Ingresar valor de la matriz ["+ (i+1) + "][" + (j+1) + "]: ");
                matriz[i][j] = objeto.nextInt();
            }
        }        
        return matriz;
    }
    
    public static void imprimirMatriz(int matriz[][]){
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
        
    }
}
