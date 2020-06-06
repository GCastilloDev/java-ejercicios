
package concurso;

import java.util.Scanner;

/**
 *
 * @author gustavo
 */
public class Ejercicio001 {
    
    
    public static void main(String[] args) {
        
         Scanner n = new Scanner(System.in);
         
        int matriz [][] = new int [8][8];
        
       
        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 8; j++) {
                System.out.print("Ingresa el valor de la posición: ["+i+"]["+j+"]: ");
                matriz[i][j] = n.nextInt();
                
            }
        }
        
        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 8; j++) {
                
                System.out.print(matriz[i][j]+" ");
                
            }
            
            System.out.println("");
            
        }
        
       boolean auxA = false;
       
        for (int i = 0; i < 7; i++) {
           
            if (matriz[0][i] == matriz[0][i+1] && matriz[7][i] == matriz[7][i+1]){
                
                auxA = true;
            }
        }
        
        for (int i = 0; i < 7; i++) {
           
            if (matriz[i][0] == matriz[i+1][0] && matriz[i][7] == matriz[i+1][7]){
                
                auxA = true;
            }
        }
        
        
        boolean auxB = false;
        
        for (int i = 1; i < 6; i++) {
           
            if (matriz[1][i] == matriz[1][i+1] && matriz[6][i] == matriz[6][i+1]){
                
                auxB = true;
            }
        }
        
        for (int i = 1; i < 6; i++) {
           
            if (matriz[i][1] == matriz[i+1][1] && matriz[i][6] == matriz[i+1][6]){
                
                auxB = true;
            }
        }
        
        
        boolean auxC = false;
        
        for (int i = 2; i < 5; i++) {
           
            if (matriz[2][i] == matriz[2][i+1] && matriz[5][i] == matriz[5][i+1]){
                
                auxC = true;
            }
        }
        
        for (int i = 2; i < 5; i++) {
           
            if (matriz[i][2] == matriz[i+1][2] && matriz[i][5] == matriz[i+1][5]){
                
                auxC = true;
            }
        }
        
        
        boolean auxD = false;
        
        if (matriz[3][3] == matriz[4][4] && matriz[3][4] == matriz[3][3] && matriz[4][3] == matriz[4][4] ){
            
            auxD= true;
        }
              
        
        
        if (auxA == true && auxB == true && auxC == true && auxD == true){
            System.out.println("Matriz concentrica");
        }
        
        else{
            System.out.println("Matriz no concentrica");
        }
        
       
    }
}
