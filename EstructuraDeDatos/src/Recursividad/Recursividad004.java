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
public class Recursividad004 {
    public static void main(String[] args) {
        
        int a = 10;
        int b = 0;
        
        System.out.println(sumaDosNumeros(a, b));
        
        
    }
    
    public static int sumaDosNumeros(int a, int b){
        
        if(a==0){
            return b;
        }
        else if (b==0){
            return a;
        }else{
            return 1 + sumaDosNumeros(a, b-1);
        }
    }
}
