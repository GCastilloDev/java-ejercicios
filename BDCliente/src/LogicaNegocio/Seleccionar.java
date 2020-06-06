package LogicaNegocio;

/**
 * 
 * @author @LastShadow
 */
public class Seleccionar {

    public String condicion(String c){
        String [] consultaDividida = c.split(" ");
        return consultaDividida[1];
    }
    
    public String tabla(String c){
        String [] consultaDividida = c.split(" ");
        return consultaDividida[2];
    }
    
    public static void main(String[] args) {
        Seleccionar seleccionar = new Seleccionar();
        String consulta = "SELECCIONAR * morita";
        System.out.println("Condición: " + seleccionar.condicion(consulta));
        System.out.println("Tabla: " + seleccionar.tabla(consulta));
    }
}
