package Ejercicio002;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class testEjercicio002 {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        List<Integer> valoresNumericos = leerValores(n);
        
        int suma = calcularSuma(valoresNumericos);
        float media = calcularMedias(valoresNumericos, suma);
        mostrarResultado(valoresNumericos, suma, media);
    }

    static List<Integer> leerValores (Scanner n){
        List<Integer> valoresNumericos = new ArrayList();
        int valor = 0;
        int i = 1;
        
        while(valor != -99){
            
            System.out.print("Ingresa un valor en posición de " + i + ": ");
            valor = n.nextInt();
            i++;
            
            if(valor != -99){
                valoresNumericos.add(valor);
            }
        }     
        
        return valoresNumericos;
    }
    
    static int calcularSuma(List<Integer> valoresNumericos){
        int suma = 0;
        
        for (int i = 0; i < valoresNumericos.size(); i++) {
            suma += valoresNumericos.get(i);
        }
        
        return suma;
    }
    
    static float calcularMedias(List<Integer> valoresNumericos, int suma){        
        return suma / valoresNumericos.size();
    }
    
    static void mostrarResultado(List<Integer> valoresNumericos, int suma, float media){
        
        System.out.println("==========LISTA DE VALORES============");
        for (int i = 0; i < valoresNumericos.size(); i++) {
            System.out.println("Número en posición " + (i+1) + ": " + valoresNumericos.get(i));
        }
        
        System.out.println("\n Suma: " + suma);
        System.out.println("Media: " + media);
        
        System.out.println("\n==========LISTA DE VALORES SUPERIORES A " + media +"============");
        for (int i = 0; i < valoresNumericos.size(); i++) {
            if(valoresNumericos.get(i) > media){
            System.out.println("Número en posición " + (i+1) + ": " + valoresNumericos.get(i));
            }
        }
    }
}
