package RA002;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Ejercicio001 {

    public static void main(String[] args) {
        
        int matriz[][] = { {1,2,3,4,5}, 
                                   {5,6,7,8,9}, 
                                   {10,11,12,13,14,15} };
        
                                
        System.out.println(suma(matriz));
    }
    
    static int suma(int matriz[][]){
        int suma = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }
    
}
