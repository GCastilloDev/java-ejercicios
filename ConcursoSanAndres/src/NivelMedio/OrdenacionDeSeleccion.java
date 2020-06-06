package NivelMedio;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class OrdenacionDeSeleccion {
    public static void main(String[] args) {
        int arreglo[] = {20,50,230,1,345,6,2,-4};
        int auxiliar = 0;
        int minimo = 0;
        
        String arregloDesordenado = "";
        for (int i = 0; i < arreglo.length; i++) {
            arregloDesordenado += arreglo[i] + " ";
        }
        System.out.println(arregloDesordenado);
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            minimo = arreglo[i];
            
            for (int j = i+1; j < arreglo.length; j++) {
                
                if(minimo > arreglo[j]){
                    minimo = arreglo[j];
                    auxiliar = arreglo[i];
                    arreglo[i] = minimo;
                    arreglo[j] = auxiliar;
                }
            }          
        }

        String arregloOrdenado = "";
        for (int i = 0; i < arreglo.length; i++) {
            arregloOrdenado += arreglo[i] + " ";
        }
        
        System.out.println(arregloOrdenado);
    }
}
