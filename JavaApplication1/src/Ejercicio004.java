
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class Ejercicio004 {
    
    public static void main(String[] args) {
        
        Scanner n = new Scanner (System.in);
        
        System.out.println("Ingrese palabra:");
        String palabra = n.next();
        
        int vocales = 0;
        
        for (int i = 0; i < palabra.length(); i++) {
            
            if(palabra.charAt(i) == 'a' || palabra.charAt(i) == 'A' ||
                    palabra.charAt(i) == 'e' || palabra.charAt(i) == 'E' ||
                    palabra.charAt(i) == 'i' || palabra.charAt(i) == 'I' ||
                    palabra.charAt(i) == 'o' || palabra.charAt(i) == 'O' ||
                    palabra.charAt(i) == 'u' || palabra.charAt(i) == 'U'){
                
                vocales++;
                
            }
            
        }
        
            
        int consonantes = palabra.length() - vocales;
        
        System.out.println("Consonantes: " + consonantes);
        System.out.println("Vocales: " + vocales);
        
    }
    
}
