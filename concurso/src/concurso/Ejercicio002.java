
package concurso;

import java.util.Scanner;

/**
 *
 * @author gustavo
 */
public class Ejercicio002 {
    
    public static void main(String[] args) {
        
        
        Scanner n = new Scanner(System.in);
        
        System.out.println("Ingresa el multiplicador: ");
        int multiplicador = n.nextInt();
        
        System.out.println("Ingresa el multiplicando: ");
        int multiplicando = n.nextInt();
        
        
        int suma = 0;
        
       while (multiplicador >= 1){
           
           int aux = 0;
           
           if (multiplicador % 2 != 0){
               
               suma = suma + multiplicando;
               //System.out.println(suma);
           }
           multiplicando *= 2;
           multiplicador = (int) multiplicador / 2;
       }
       
      System.out.println("suma: " + suma);        
        
        
    }
    
}
