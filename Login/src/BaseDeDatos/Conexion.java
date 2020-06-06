package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; //Ejecuta sentencias SQL
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La siguiente clase permite establecer una conexión a una base de datos en
 * MySQL Se implementará en el patron de diseño Singleton.
 *
 * @author LastShadow
 */
public class Conexion {

    //Este atributo me va a representar un único objeto.
    private static Conexion conexion = null;

    //Tercer paso: Atributos de la conexión.
    private final String USUARIO = "root";
    private final String PSW = "";
//    private final String NOMBRE_BD = "bdutsv";
    private final String NOMBRE_BD = "login";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String CADENA_CONEXION = "jdbc:mysql://localhost/" + this.NOMBRE_BD;
    private Connection con;

    //Primer paso: Encapsular el constructor de la clase.
    private Conexion() {
        try {
            //Paso cuatro: Cargar los controladores.
            Class.forName(this.DRIVER);
            System.out.println("Los controladores se carganarón con éxito.");

            /*
            Paso cinco: Establecer la conexión a la base de datos. La conexión
            a través de la clase DriverManager la cual devuelve un objeto de
            tipo Connection, este objeto mantiene el estado de la conexión.
             */
            con = DriverManager.getConnection(this.CADENA_CONEXION, this.USUARIO, this.PSW);
            System.out.println("Conectado a la base de datos con éxito.");

        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudieron cargar los controladores de MySql."
                    + "\nError: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("No se pudo establecer la conexión a la base de datos."
                    + "\nError: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
    }

    //Segundo paso: Crear un método de acceso, debe de ser público y de clase.
    /**
     * @return Retorna un único objeto de tipo Conexion.
     */
    public static Conexion getConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }

        return conexion;
    }

    //Paso cinco: crear métodos para el CRUD.
    /*
    Método utilizado para ejecutar la sentencia SQL: SELECT
     */
    public ResultSet consultar(String consulta) {
        try {
            Statement consultaSQL = con.createStatement();
            ResultSet resultado;
            resultado = consultaSQL.executeQuery(consulta);
            resultado.first();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error de comunicación con la base de datos. "
                    + ex.getMessage());
        }
        return null;
    }

    /*
    Método utlizado para ejecutar las sentencias SQL: INSERT, UPDATE Y DELETE
     */
    public int consultarIUD(String consulta) {
        try {
            Statement realizarIUD = con.createStatement();
            int resultado = realizarIUD.executeUpdate(consulta);
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error en la ejecución de IUD. " + ex.getMessage());
        }
        return -1; //Si hubo un error en la consulta
    }
    
    public void cerrar(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
//                    System.out.println(Conexion.getConexion());
        Conexion conexion = Conexion.getConexion();
        String consulta;
//        consulta = "INSERT INTO `tb_alumnos`(`matricula`, `nombre`, `apellidos`, `genero`, `calle`, `colonia`, `cp`, `ciudad`, `estado`, `celular`, `numero_fijo`, `correo`, `facebook`, `twitter`, `carrera`) VALUES ('1710695','Erick Esteban','Alcudia Reyes Rivera','M','Antonio Esparza','Paraiso','96523','Coatzacoalcos','Veracruz','9212804492','9212804492', 'gusatvoc.mx@gmail.com','gcnMX','gcnMX','TSU TIC')";
        consulta = "SELECT `usuario`, `psw` FROM `usuario` WHERE `usuario`='yosiel' AND `psw` = '1234'";
        int registrosAfectados = conexion.consultarIUD(consulta);

//        System.out.println("Registros afectados: " + registrosAfectados);
//        consulta = "SELECT * FROM tb_alumnos";
        ResultSet resultado = conexion.consultar(consulta);
        try {
            System.out.println(resultado.getRow());
//        try {
//            do {
//                System.out.print(resultado.getInt(1) + " ");
//                System.out.print(resultado.getString(2) + " ");
//                System.out.print(resultado.getString(3) + " ");
//                System.out.print(resultado.getString(4) + " ");
//                System.out.print(resultado.getString(5) + " ");
//                System.out.print(resultado.getString(6) + " ");
//                System.out.print(resultado.getString(7) + " ");
//                System.out.print(resultado.getString(8) + " ");
//                System.out.print(resultado.getString(9) + " ");
//                System.out.print(resultado.getString(10) + " ");
//                System.out.print(resultado.getString(11) + " ");
//                System.out.print(resultado.getString(12) + " ");
//                System.out.print(resultado.getString(14) + " ");
//                System.out.print(resultado.getString(15) + " ");
//                System.out.print(resultado.getString(16) + " ");
//                System.out.println("");
//            } while (resultado.next());
//        } catch (SQLException ex) {
//            System.out.println("Error al devolver la información. " + ex.getMessage());
//        }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
