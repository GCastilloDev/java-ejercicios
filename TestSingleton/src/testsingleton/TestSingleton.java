package testsingleton;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestSingleton {

    
    public static void main(String[] args) {
               
        //Mandamos a llamar el método de clase
        ConexionBD conexion = ConexionBD.getConexion();
        ConexionBD conexion2 = ConexionBD.getConexion();
        ConexionBD conexion3 = ConexionBD.getConexion();

        System.out.println(conexion);
        System.out.println(conexion2);
        System.out.println(conexion3);
        
    }
    
}
