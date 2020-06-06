/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testencontrarvector;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TestEncontrarVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [][] arreglo = {{4,6,2},{4,6,2},{4,6,2}};
        int [] vector = {4,6,2};
        
        System.out.println(cuantasVecesHayVector(arreglo, vector));
        
    }
    
    static int cuantasVecesHayVector(int [][] arreglo, int [] vector){
        boolean existeVector = false;
        int contador = 0;
        
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                if(arreglo[i][j] == vector[j]){
                    existeVector = true;
                }else{
                    existeVector = false;
                }
            }
            
            if(existeVector){
                contador++;
            }
        }
        
        return contador;
    }
    
}
