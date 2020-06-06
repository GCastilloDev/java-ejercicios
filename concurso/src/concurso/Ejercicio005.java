/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

import java.util.Scanner;

/**
 *
 * @author gustavo
 */
public class Ejercicio005 {
    
    public static void main(String[] args) {
        
        Scanner n = new Scanner (System.in);
        int matriz [][] = new int [5][3];
        
       
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                
                System.out.println("ingrese valor ["+i+"]["+j+"]: ");
                matriz[i][j] = n.nextInt();
            }
            
        }
        
        suma_lineas(matriz);
        suma_columnas(matriz);
        
    }
    
    
    static void suma_lineas(int matriz[][]){
        
        int suma1 = matriz[0][0] + matriz[0][1] + matriz [0][2];
        int suma2 = matriz[1][0] + matriz[1][1] + matriz [1][2];
        int suma3 = matriz[2][0] + matriz[2][1] + matriz [2][2];
        int suma4 = matriz[3][0] + matriz[3][1] + matriz [3][2];
        int suma5 = matriz[4][0] + matriz[4][1] + matriz [4][2];
        
              
       System.out.println(suma1 + "," + suma2 + "," + suma3 + "," + suma4 + "," + suma5);      
          
        
    }
    
    
     static void suma_columnas(int matriz[][]){
        
        int suma1 = matriz[0][0] + matriz[0][1] + matriz [0][2] + matriz[0][3] + matriz[0][4];
        int suma2 = matriz[1][0] + matriz[1][1] + matriz [1][2] + matriz[1][3] + matriz[1][4];
        int suma3 = matriz[3][0] + matriz[3][1] + matriz [3][2] + matriz[3][3] + matriz[3][4]; 
        
              
       System.out.println(suma1 + "," + suma2 + "," + suma3);      
          
        
    }
    
}
