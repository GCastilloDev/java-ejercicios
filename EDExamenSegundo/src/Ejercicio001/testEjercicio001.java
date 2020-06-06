package Ejercicio001;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class testEjercicio001 {
    
    public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        List<Double> alturaAlumnos = leerAlturas(numeroAlumnos(n), n);
        mostrarResultados(alturaAlumnos, calcularMedias(alturaAlumnos));
        
    }

    static int numeroAlumnos(Scanner n){
        System.out.println("¿Cuantos alumnos desea ingresar?");
        int numeroAlumnos = n.nextInt();
        return numeroAlumnos;
    }
    
    static List<Double> leerAlturas(int numeroAlumnos, Scanner n){
        List<Double> alturaAlumnos = new ArrayList();
//        int fin = numeroAlumnos;
        
        for (int i = 0; i < numeroAlumnos; i++) {
            System.out.print("Ingresa la altura del alumno[" + (i+1) + "]: ");
            double altura = n.nextDouble();
            while (altura <=0){
                System.out.print("Volver a introducir la altura del alumno[" + (i+1) + "]: ");
                altura = n.nextDouble();
            }
            alturaAlumnos.add(i,altura);
        }
        
        return alturaAlumnos;
    }
    
    static double calcularMedias(List<Double> alturaAlumnos){
        double mediasAlumnos = 0;
        
//        for (int i = 0; i < alturaAlumnos.size(); i++) {
//            mediasAlumnos += alturaAlumnos.get(i);
//        }
        for (Double elemento : alturaAlumnos) {
            mediasAlumnos += elemento;
        }
        
        return mediasAlumnos / alturaAlumnos.size();
    }
    
    static void mostrarResultados(List<Double> alturaAlumnos, double medias){
        
        System.out.println("==========>Lista altura de alumnos<==========");
        for (int i = 0; i < alturaAlumnos.size(); i++) {
            System.out.println("Alumno [" + (i+1) + "]: " + alturaAlumnos.get(i));
        }
        
        System.out.println("\n==========>Lista alumnos con altura superior a " + medias +"<==========");
        for (int i = 0; i < alturaAlumnos.size(); i++) {
            if(alturaAlumnos.get(i) > medias){
                System.out.println("Alumno [" + (i+1) + "]: " + alturaAlumnos.get(i));
            }
        }
        
        System.out.println("\n==========>Lista alumnos con inferior superior a " + medias +"<==========");
        for (int i = 0; i < alturaAlumnos.size(); i++) {
            if(alturaAlumnos.get(i) < medias){
                System.out.println("Alumno [" + (i+1) + "]: " + alturaAlumnos.get(i));
            }
        }
    }
}
