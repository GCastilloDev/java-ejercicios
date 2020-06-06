package Ejercicio001;

import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio005 {
    
    public static void main(String[] args) {
        
        llenarArreglos();
    }
    
    public static void llenarArreglos(){
        float kilometros[] = new float[3];
        float litrosGasolina[] = new float[3];
        
        Scanner n = new Scanner(System.in);
        
        for (int i = 0; i < kilometros.length; i++) {
            System.out.print("Introduce los kilometros recorridos por el tanque [" + (i+1) + "]: ");
            kilometros[i] = n.nextFloat();
            System.out.print("Introduce los litros consumidos en el tanque [" + (i+1) + "]: ");
            litrosGasolina[i] = n.nextFloat();
            System.out.println("");
        }
        
        for (int i = 0; i < kilometros.length; i++) {
            System.out.println("Rendimiento del tanque [" + (i+1) + "]....." + 
                    calcularRendimiento(kilometros[i],litrosGasolina[i]) + " kilometros por litro");
        }
        
    }
    
    public static float calcularRendimiento(float kilometros, float litros){
        return kilometros / litros;
    }
}
