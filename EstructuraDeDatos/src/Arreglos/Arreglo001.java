package Arreglos;

import java.util.Scanner;

/**
 *
 * @author gustavo
 */

/*
Promedio de calificaciones
*/

public class Arreglo001 {
    
    public static void main(String[] args) {
        
        int calificacionesAlumnos[] = new int[3];
        
        Scanner n = new Scanner(System.in);
        
        float suma = 0;
        
        //Llenar un arreglo:
        for (int i = 0; i < calificacionesAlumnos.length; i++) {
            
            System.out.println("Ingresa la calificación [" + (i+1) + "]: ");
            calificacionesAlumnos[i] = n.nextInt();
            suma += calificacionesAlumnos[i];
        }
        
     
        float promedio = suma / calificacionesAlumnos.length;
        
        System.out.println("El promedio del grupo es: " + promedio);       
        
    }
    
}
