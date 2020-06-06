/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NivelAvanzado;

import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class prueba {
    public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        System.out.println("ingresa un numero");
        float a = n.nextFloat();
        System.out.println("ingresa otro numero ");
        float b = n.nextFloat();
        
        float suma = a + b;
        System.out.println("resultado " + suma);
    }
}
