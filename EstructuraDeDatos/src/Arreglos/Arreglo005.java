package Arreglos;

/**
 * 
 * @author Gustavo
 */
public class Arreglo005 {
    
    /**
     * Dado un array de números de 5 posiciones con los siguientes valores
     * {1,2,3,4,5}, guardar los valores de este array en otro array distinto
     * pero con los valores invertidos, es decir que el segundo array deberá 
     * tener los valores {5,4,3,2,1}.
     */
    
    public static void main(String[] args) {
        
        int arregloInicial[] = {1,2,3,4,5};
        int arregloFinal[] = new int [arregloInicial.length];
        int posicion = arregloInicial.length - 1;
        
        for (int i = 0; i < arregloInicial.length; i++) {
            
            arregloFinal[i] = arregloInicial[posicion];
            posicion--;
            
        }
        
        String cadena = "{";

        for (int i = 0; i < arregloFinal.length; i++) {
            
            if(i < arregloFinal.length-1){
            cadena+=arregloFinal[i] + ",";
            }
            else{
                cadena+=arregloFinal[i] + "}";
            }
            
        }
        
        System.out.println(cadena);
        
    }
    
    
}
