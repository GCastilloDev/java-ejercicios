package Recursividad;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Recursividad002 {

    public static void main(String[] args) {
        /**
         * Buscar un elemento de un array en forma recursiva.
         */

        int arreglo[] = {1, 2, 3, 4, 5};
        int elementoBuscar = 5;
        
        int posicion = buscarElemento(arreglo, elementoBuscar, 0);
        
        if (posicion != -1){
        System.out.println("Elemento encontrado en la posicion: " + posicion);
        }
        else{
            System.out.println("Elemento no encontrado " + posicion);
        }
        
    }
    
    static int buscarElemento(int arreglo[], int elementoBuscar, int posicion){
        
        if(posicion == arreglo.length){
            return -1;
        }
        
        if(arreglo[posicion] == elementoBuscar){
            return posicion;
        }else{
            return buscarElemento(arreglo, elementoBuscar, posicion+1);
        }
        
    }

}
