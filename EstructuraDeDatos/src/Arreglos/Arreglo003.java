package Arreglos;

import java.util.Scanner;

/**
 *
 * @author gustavo
 */

/*
Crea un programa en el que se pida por consola el nombre de dos alumnos y la nota
de cada uno de ellos como valor númerico. El resultado que debe mostrarse es el
nombre de cada alumno, su nota y su calificación como texto (Sobresaliente, notable,
bien o reprobado, para ello crea un Array número y otro de String (ambos unidimensionales),
en el array númerico se insertaran las calificaciones proporcionadas por el usuario, entre
0 y 10 (debemos controlar que inserte una nota válida), pudiendo ser decimal, en el array
de String se insertaran los nombres de los alumnos.

Crea también un array de String donde insertaremos el resultado de la nota con palabras
sobresaliente, notable, bien o reprobado.

El programa debe comprobar la nota de cada alumno teniendo en cuenta esta equivalencia:

*0 - 4.99 Reprobado
*5 - 6.99 Bien
*7 - 8.99 Notable
*9 - 10 Sobresaliente
 */

public class Arreglo003 {

    public static void main(String[] args) {

        String nombre[] = new String[2];
        float calificacion[] = new float[2];
        String nota[] = new String[2];

        Scanner n = new Scanner(System.in);

        for (int i = 0; i < nombre.length; i++) {

            System.out.print("Ingresa el nombre del alumno [" + (i + 1) + "]: ");
            nombre[i] = n.next();
            System.out.print("Ingresa la calificación de " + nombre[i] + ": ");
            calificacion[i] = n.nextFloat();
            
            while (calificacion[i] > 10 || calificacion[i] < 0){
                System.out.println("\nDebes de insertar una calificación válida entre 0 y 10\n"
                            + "Favor de volver a insertar la calificación de " + nombre[i] + ": ");
                    calificacion[i] = n.nextFloat();
            }
            
            
            /*
            if (calificacion[i] > 10 || calificacion[i] < 0) {

                do {
                    System.out.println("\nDebes de insertar una calificación válida entre 0 y 10\n"
                            + "Favor de volver a insertar la calificación de " + nombre[i] + ": ");
                    calificacion[i] = n.nextFloat();
                } while (calificacion[i] > 10 || calificacion[i] < 0);
                
            }
            */
            
            
            if (calificacion[i] >= 0 && calificacion[i] <= 4.99) {
                nota[i] = "Reprobado";
            } else if (calificacion[i] >= 5 && calificacion[i] <= 6.99) {
                nota[i] = "Bien";
            } else if (calificacion[i] >= 7 && calificacion[i] <= 8.99) {
                nota[i] = "Notable";
            } else if (calificacion[i] >= 9 && calificacion[i] <= 10) {
                nota[i] = "Sobresaliente";
            }
        }

        for (int i = 0; i < nombre.length; i++) {
            System.out.println("El alumno " + nombre[i]
                    + " tiene una calificación de " + calificacion[i]
                    + " y una nota de: " + nota[i]);
        }

    }
}
