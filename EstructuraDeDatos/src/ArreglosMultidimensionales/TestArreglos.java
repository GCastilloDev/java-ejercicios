package ArreglosMultidimensionales;

import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class TestArreglos {
    
    public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        
        int matriz[][] = Matriz3.llenarMatriz(n);
        
        System.out.println("");
        System.out.println("Matriz llena:");
        Matriz3.imprimirMatriz(matriz);
        
    }

}
