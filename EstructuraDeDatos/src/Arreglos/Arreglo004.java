package Arreglos;

import java.util.Scanner;

/**
 * 
 * @author Gustavo 
 */
public class Arreglo004 {

    public static void main(String[] args) {
        
        /**
         * Pide al usuario por teclado una frase y pasa sus carácteres a un
         * array de carácteres.
         */
        
        Scanner n = new Scanner(System.in);
        
        System.out.println("Ingresa una frase:");
        String frase = n.nextLine();
        int tamaño = frase.length();
        char cadena[] = new char[tamaño];
        
        
        for (int i = 0; i < tamaño; i++) {
            
            cadena[i]  = frase.charAt(i);
        }
        
        System.out.println("");
        
        for (int i = 0; i < frase.length(); i++) {
            
            System.out.print(cadena[i]);
        }
        
        System.out.println("");
    }
}
