package LogicaNegocio;

/**
 *
 * @author @LastShadow
 */
public class MensajeEntrada {

    public int consultaRequerida(String consulta) {
        int respuesta = 100;

        if (primeraPalabra(consulta).equals("CREAR")) {
            if (segundaPalabra(consulta).equals("BD")) {
                respuesta = 1;
            }
            if (segundaPalabra(consulta).equals("TABLA")) {
                respuesta = 2;
            }
        }

        if (primeraPalabra(consulta).equals("SELECCIONAR")) {
            respuesta = 3;
        }

        if (primeraPalabra(consulta).equals("AGREGAR")) {
            respuesta = 4;
        }

        if (primeraPalabra(consulta).equals("ELIMINAR")) {
            respuesta = 5;
        }

        if (primeraPalabra(consulta).equals("ACTUALIZAR")) {
            respuesta = 6;
        }

        return respuesta;
    }

    private String primeraPalabra(String consulta) {
        String[] consultaDividida = consulta.split(" ");
        return consultaDividida[0];
    }

    private String segundaPalabra(String consulta) {
        String[] consultaDividida = consulta.split(" ");
        return consultaDividida[1];
    }
    
    public static void main(String[] args) {
        
        MensajeEntrada mensaje = new MensajeEntrada();
        String consulta = "ACTUALIZAR";
        int respuesta = mensaje.consultaRequerida(consulta);
        System.out.println(respuesta);
        
    }
}
