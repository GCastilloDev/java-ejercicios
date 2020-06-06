package Ejercicio001;

import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio003 {
    //Formula
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        
        System.out.println("Ingresa el valor de a:");
        float a = n.nextFloat();
        if(a != 0){
            System.out.println("Ingresa el valor de b:");
            float b = n.nextFloat();
            System.out.println("Ingresa el valor de c:");
            float c = n.nextFloat();
            System.out.println("Ingresa el valor de d:");
            float d = n.nextFloat();
            System.out.println("El resultado es: " + calcularFormula(a, b, c, d));
        }else{
            System.out.println("Programa terminado.");
        }
    }
    
    public static float calcularFormula(float a, float b, float c, float d){
        return ( ( ( a + b ) / 2) * (( c * d) / a) ) + 1;
    }
}
