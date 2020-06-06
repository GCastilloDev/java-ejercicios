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
public class Recursividad006 {
    public static void main(String[] args) {
    
        int num = 5;
        
        System.out.println(factorial(num));
    }
    
    public static int factorial (int num){
        
        if (num==1){
            return 1;
        }
        
        return num * factorial(num-1);
    }
}
