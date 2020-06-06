/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Recursividad;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Recursividad003 {
    
    public static void main(String[] args) {
        int num = 9;
        
        int x = sumaRecursiva(num);
        System.out.println(x);
    }
    
    public  static int sumaRecursiva(int numero){
        int res;
        
        if (numero == 1){
            return 1;
        }else{
        
        return res  = numero + sumaRecursiva(numero-1);
        }
    }

}
