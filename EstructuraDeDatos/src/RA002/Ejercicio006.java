package RA002;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */

/*
*Realizar un programa que lea tantos números de enteros como desee el usuario,
*y los introduzca en una lista. Muestra la lista, intercambia los números que se
*encuentren en la segunda y cuarta posición y muestra de nuevo la lista por
*pantalla.
*/
public class Ejercicio006 {
    
    public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        List<Integer> numeros = llenarLista(n);
        System.out.println("===========>CONTENIDO DE LA LISTA<===========");
        imprimirLista(numeros);
        
        if(numeros.size() >= 4){
            System.out.println("===========>LISTA ORDENADA<===========");
        ordenarLista(numeros);
        imprimirLista(numeros);
        }else{
            System.out.println("\nLa lista contiene menos de cuatro elementos, "
                    + "no es posible ordenarla.");
        }
        
    }
    
    static List<Integer> llenarLista(Scanner n){
        
        List<Integer> numeros = new ArrayList();
        
        char continuar = ' ';
        int contador = 1;
        
        do{
            System.out.print("Ingrese número en posición [" + contador+ "]: ");
            numeros.add(n.nextInt());
            System.out.print("¿Desea agregar otro número? S para sí N para no: ");
            continuar = n.next().charAt(0);
            contador++;
        }while (continuar == 's' || continuar == 'S');       

        return numeros;
    }
    
    static void imprimirLista(List<Integer> numeros){ 
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println("Posición " + (i+1) + ": " + numeros.get(i));
        }
    }
    
    static List<Integer> ordenarLista(List<Integer> numeros){
        
        int posicionDos = numeros.get(1);
        int posicionCuatro = numeros.get(3);
              
        numeros.set(1, posicionCuatro);      
        numeros.set(3, posicionDos);
        
        return numeros;
    }

}
