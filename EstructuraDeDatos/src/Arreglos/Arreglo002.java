package Arreglos;

import java.util.Arrays; 
import java.util.Scanner;

/**
 *
 * @author gustavo
 */
public class Arreglo002 {
    
    public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        int numeros[] = new int[10];
        
        int suma = 0;
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingresa el número [" + (i+1) + "]: ");
            numeros[i] = n.nextInt();
            suma += numeros[i];
        }
        
        int numeroMayor = numeros[0];
        int numeroMenor = numeros[0];
        
        for (int i = 1; i < numeros.length; i++) {
            
            if(numeros[i] > numeroMayor){
                numeroMayor = numeros[i];
            }
            
            if (numeroMenor > numeros[i]){
                numeroMenor = numeros[i];                
            }
           
        }
        
        
        
        
        System.out.println("Mayor: "  + numeroMayor);
        System.out.println("Menor: " + numeroMenor);
        System.out.println("Suma: " + suma);
        
//        Arrays.sort(numeros);
//        
//        System.out.println("Suma: " + suma);
//        System.out.println("El mayor es: " + numeros[9]);
//        System.out.println("El menor es: " + numeros[0]);
    }
}
