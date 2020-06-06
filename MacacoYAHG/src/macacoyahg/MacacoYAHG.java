package macacoyahg;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class MacacoYAHG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        Buscar un array de forma recursiva
        */
        
        //Primer paso: Crear el array en donde se buscará el elemento.
        int arreglo[] = {1,2,3,4,5};
        
        //Crear una variable que contenga el elemento que se quiere buscar
        //dentro del arreglo
        int elementoBuscar = 10;
        
        //Crear una variable donde nos guarde la posición del elemento que
        //buscaremos
        int posicionEncontrada;
        
        //Asignamos la posición del arreglo a la variable
        posicionEncontrada = buscarElemento(arreglo, elementoBuscar, 0);
        
        //Imprimimos la posición
        System.out.println(posicionEncontrada);//El elemento se encuentra en la posicion 2 del arreglo
    }
    
    //Creamos el método recursivo    
    public static int buscarElemento(int arreglo[], int elementoBuscar, int posicion){
        
        //Se necesita saber si el elemento no se encuentra, para esto cuando el elemento
        //no se encuentre retornaremos "-1"
        if(posicion == arreglo.length){
            return -1;
        }        
        
        //Necesitamos tener un caso base, que nos permita "romper o regresar"
        //de la recursividad
        
        //Si el elemento que buscamos es igual al elemento que tenemos en el arreglo
        //se "rompe" y hace el retorno
        
        if(elementoBuscar == arreglo[posicion]){
            return posicion;
        }else{
            return buscarElemento(arreglo, elementoBuscar, posicion+1);
        }
              
    }
    
}
