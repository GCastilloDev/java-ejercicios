package LogicaNegocio;

/**
 *
 * @author @LastShadow
 */
public class CrearTabla {

    public String nombreTabla(String consulta) {
        String[] consultaDividida = consulta.split(" ");
        return consultaDividida[2];
    }

    public String camposTabla(String consulta) {
        String[] consultaDividida = consulta.split(" ");
        return consultaDividida[3];
    }

    public static void main(String[] args) {
        CrearTabla tabla = new CrearTabla();
        String consulta = "CREAR TABLA morita     nombre,apellido,casa";
        String consulta2 = consulta.replace(" ","");
        System.out.println("consulta 2: " + consulta2);
        System.out.println("Nombre de la tabla: " + tabla.nombreTabla(consulta));
        System.out.println("Campos de la tabla: " + tabla.camposTabla(consulta));

        String[] prueba = consulta.split(" ");

        for (int i = 0; i < prueba.length; i++) {
            System.out.println(i + " " + prueba[i]);
        }
    }
}
