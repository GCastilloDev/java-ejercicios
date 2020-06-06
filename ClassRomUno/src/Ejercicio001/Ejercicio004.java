package Ejercicio001;

import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio004 {

    //Invertir palabras
    public static void main(String[] args) {
        
     
        Scanner n = new Scanner(System.in);
        
        System.out.print("Ingresa los casos: ");
        int casos = n.nextInt();
        n.nextLine();
        
        String palabras[] = new String[casos];
        
        for (int i = 0; i < palabras.length; i++) {
            System.out.print("Frase [" + (i+1) + "]:");
            palabras[i] = n.nextLine();
        }
               
        for (int i = 0; i < palabras.length; i++) {
            
            String prueba[] = palabras[i].split(" ");
            System.out.print("Caso #" + (i+1) + ": ");
            
            for (int j = prueba.length; j > 0; j--) {
                
                System.out.print(prueba[j-1] + " ");
            }
            System.out.println("");
        }
        /*
        String palabra = "esto es un texto";
        
        String prueba[] = palabra.split(" ");
        
        for (int i = 0; i < prueba.length; i++) {
            System.out.println(prueba[i]);
        }*/
        
        
    }
    }

