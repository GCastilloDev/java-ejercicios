package testsingleton;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ConexionBD {
    
    private static ConexionBD conexion;
    
    //Primero paso:
    //Encapsular el constructor
    private ConexionBD(){
        
    }

    //Métodos de objeto:
    public void conectar(){
        
    }
    
    public void cerrar(){
        
    }
    
    //Método de clase:
    //Va a permitir crear el patrón Singleton
    //Segundo paso:
    //Crear la instancia en el método getConexion
    public static ConexionBD getConexion(){
        //Verificar si la instancia a sido creada
        if (conexion == null){        
        return conexion = new ConexionBD();
        }
        else{
            return conexion;
        }
    }
    
}
