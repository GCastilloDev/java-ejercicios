package Ejercicio003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class testEjercicio003 {
    public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        List<Coche> coches = llenarLista(n);
        mostrarTodos(coches);
        mostrarPorMarca(coches, n);
        mostrarPorKilometros(coches, n);
        mostrarMayorKM(coches);
        mostrarMenorMayor(coches);      
        
    }
    
    static List<Coche> llenarLista(Scanner n){
        List<Coche> coches = new ArrayList();
        int next = 1;
        
        while(next == 1){
            Coche coche = new Coche();
            System.out.print("Introduce la matrícula : " );
            coche.setMatricula(n.nextLine());
            System.out.print("Introduce la marca: ");
            coche.setMarca(n.nextLine());
            System.out.print("Introduce el modelo: ");
            coche.setModelo(n.nextLine());
            System.out.println("Introduce el kilometraje: ");
            coche.setKm(n.nextInt());
            System.out.println("¿Deseas continuar? (1) Si (2) No");
            next = n.nextInt();
        }      
        
        return coches;
    }
    
    static void mostrarTodos(List<Coche> coches){
        System.out.println("========LISTA DE TODOS LOS CARROS=======");
        for (int i = 0; i < coches.size(); i++) {
            System.out.println(coches.get(i).toString());
        }
    }
    
    static void mostrarPorMarca(List<Coche> coches, Scanner n){
        
        System.out.println("¿Marca a buscar?");
        String marca = n.nextLine();
        
        System.out.println("========LISTA POR KILOMETRAJE=======");
        for (int i = 0; i < coches.size(); i++) {
            if(coches.get(i).getMarca().equalsIgnoreCase(marca)){
              System.out.println(coches.get(i).toString());
            }
        }
    }
    
    static void mostrarPorKilometros(List<Coche> coches, Scanner n){
        
        System.out.println("¿Kilometraje a buscar?");
        int km = n.nextInt();
        
        System.out.println("========LISTA POR KILOMETRAJE=======");
        for (int i = 0; i < coches.size(); i++) {
            if(coches.get(i).getKm() == km){
              System.out.println(coches.get(i).toString());
            }
        }
    }
    
    static void mostrarMayorKM(List<Coche> coches){
        
        Collections.sort(coches, Collections.reverseOrder());
        System.out.println("=======MAYOR KILOMETRAJE========");
        System.out.println(coches.get(0).toString());
    }
    
    static void mostrarMenorMayor(List<Coche> coches){
        
        System.out.println("========LISTA POR KILOMETRAJE DE MENOR A MAYOR=======");
        Collections.sort(coches);
        
        for (int i = 0; i < coches.size(); i++) {
          
              System.out.println(coches.get(i).toString());
            
        }
    }

}
