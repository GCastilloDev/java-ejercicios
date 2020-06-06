package LogicaNegocio;

/**
 * 
 * @author @LastShadow
 */
public class CrearBD {

    public String nombreBD(String consulta){        
        String [] consultaDividida = consulta.split(" ");   
        return consultaDividida[2];
    }
    
    public static void main(String[] args) {
        CrearBD crearBD = new CrearBD();
        String consulta = "CREAR BD hola ";
        System.out.println(crearBD.nombreBD(consulta));
    }
}
