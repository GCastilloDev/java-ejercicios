package Recursividad;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Recursividad001 {

    public static void main(String[] args) {
        /**
         * Recorrer un arreglo de forma recursiva.
         *
         */
        
        int arreglo[] = {1,2,3,4,5};
        
        String cadena = recorrerArreglo(arreglo, 0);
        System.out.println(cadena);
        
    }
    
    public static String recorrerArreglo(int arreglo[], int posicion){
        String res;
        
        if (posicion == arreglo.length-1){
            return res = arreglo[posicion] + "";
        }else{
            return res = arreglo[posicion] + recorrerArreglo(arreglo, posicion+1);
        }
        
    }
}
