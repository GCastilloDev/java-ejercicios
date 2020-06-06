package Modelo.BaseDeDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author @LastShadow
 */
public class ProcedimientoAlmacenado {

    public static boolean insertarRegistro(String matricula,
            String nombre,
            String apellidos,
            String genero,
            String calle,
            String colonia,
            String cp,
            String ciudad,
            String estado,
            String celular,
            String nFijo,
            String correo,
            String facebook,
            String twitter,
            String carrera,
            String indexCarrera) {
        try {
            Connection con = Conexion.getConexion().conexion();
            CallableStatement insertar = con.prepareCall("{CALL agregarAlumno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            insertar.setString(1, matricula);
            insertar.setString(2, nombre);
            insertar.setString(3, apellidos);
            insertar.setString(4, genero);
            insertar.setString(5, calle);
            insertar.setString(6, colonia);
            insertar.setString(7, cp);
            insertar.setString(8, ciudad);
            insertar.setString(9, estado);
            insertar.setString(10, celular);
            insertar.setString(11, nFijo);
            insertar.setString(12, correo);
            insertar.setString(13, facebook);
            insertar.setString(14, twitter);
            insertar.setString(15, carrera);
            insertar.setString(16, indexCarrera);
            insertar.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Hubo un error al realizar el registro. Error: " + ex.getMessage());
            System.out.println("Código de error: " + ex.getErrorCode());
            return false;
        }
    }

    public static boolean actualizarRegistro(String matricula,
            String nombre,
            String apellidos,
            String genero,
            String calle,
            String colonia,
            String cp,
            String ciudad,
            String estado,
            String celular,
            String nFijo,
            String correo,
            String facebook,
            String twitter,
            String carrera,
            String indexCarrera) {
        try {
            Connection con = Conexion.getConexion().conexion();
            CallableStatement insertar = con.prepareCall("{CALL actualizarAlumno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            insertar.setString(1, matricula);
            insertar.setString(2, nombre);
            insertar.setString(3, apellidos);
            insertar.setString(4, genero);
            insertar.setString(5, calle);
            insertar.setString(6, colonia);
            insertar.setString(7, cp);
            insertar.setString(8, ciudad);
            insertar.setString(9, estado);
            insertar.setString(10, celular);
            insertar.setString(11, nFijo);
            insertar.setString(12, correo);
            insertar.setString(13, facebook);
            insertar.setString(14, twitter);
            insertar.setString(15, carrera);
            insertar.setString(16, indexCarrera);
            insertar.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Hubo un error al realizar el registro. Error: " + ex.getMessage());
            System.out.println("Código de error: " + ex.getErrorCode());
            return false;
        }
    }
    
    public static ResultSet buscarAlumnos(String matricula) {
        try {
            Connection con = Conexion.getConexion().conexion();
            CallableStatement buscar = con.prepareCall("{CALL buscarAlumno(?)}");
            buscar.setString(1, matricula);
            buscar.execute();
            return buscar.getResultSet();
        } catch (SQLException ex) {
            Logger.getLogger(ProcedimientoAlmacenado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean eliminarAlumnos(String matricula){
        try {
            Connection con = Conexion.getConexion().conexion();
            CallableStatement eliminar = con.prepareCall("{CALL eliminarRegistro(?)}");
            eliminar.setString(1, matricula);
            eliminar.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProcedimientoAlmacenado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            //        System.out.println(insertarRegistro("1710680", "Ana Elisa", "Castillo Nájera", "F", "Antonio Esparza Castillo", "Paraiso", "96523", "Coatzacoalcos", "Veracruz", "1234567890", "1234567890", "ana@gmail.com", "eli94", "eli94", "TSU TIC"));
            
            
            ResultSet resultado = buscarAlumnos("1710692");
            resultado.next();
            System.out.print(resultado.getInt(1) + " ");
            System.out.print(resultado.getString(2) + " ");
            System.out.print(resultado.getString(3) + " ");
            System.out.print(resultado.getString(4) + " ");
            System.out.print(resultado.getString(5) + " ");
            System.out.print(resultado.getString(6) + " ");
            System.out.print(resultado.getString(7) + " ");
            System.out.print(resultado.getString(8) + " ");
            System.out.print(resultado.getString(9) + " ");
            System.out.print(resultado.getString(10) + " ");
            System.out.print(resultado.getString(11) + " ");
            System.out.print(resultado.getString(12) + " ");
            System.out.print(resultado.getString(14) + " ");
            System.out.print(resultado.getString(15) + " ");
            System.out.print(resultado.getString(16) + " ");
            System.out.print(resultado.getString(17));
        } catch (SQLException ex) {
            System.out.println("Error al consultar. " + ex.getMessage());  
            System.out.println("Codigo: " + ex.getErrorCode());
        }
    }

}
