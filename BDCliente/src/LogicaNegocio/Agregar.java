package LogicaNegocio;

/**
 * 
 * @author @LastShadow
 */
public class Agregar {

    public String nombreTabla(String c){
        String [] campos = c.split(" ");
        return campos[1];
    }
    
    public String campos(String c){
        String [] campos = c.split(" ");
        return campos[3];
    }    
    
    public static void main(String[] args) {
        Agregar a = new Agregar();
        String consulta = "AGREGAR morita VALOR orlando,mulato";
        System.out.println(a.nombreTabla(consulta));
        System.out.println(a.campos(consulta));
    }
}
