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
public class Recursividad005 {

    public static void main(String[] args) {
        
        String palabra = "hola";
        System.out.println(palabraInversa(palabra));
    }
    
    public static String palabraInversa (String palabra){
        if (palabra.length() <= 1) {
        return palabra;
    }
    return palabraInversa(palabra.substring(1)) + palabra.charAt(0);
        
        
     }
}
