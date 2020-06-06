package testconcursoventas;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TestConcursoVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Venta ventas[] = new Venta[10];
               
        ventas[0] = new Venta("Yosiel",110);
        ventas[1] = new Venta("Juan", 22000);
        ventas[2] = new Venta("Orlando",180);
        ventas[3] = new Venta("Pablo",250);
        ventas[4] = new Venta("Carlos",500);
        ventas[5] = new Venta("Karla", 69);
        ventas[6] = new Venta("Luis", 5500);
        ventas[7] = new Venta("Alcudia", 250);
        ventas[8] = new Venta("Marco",7);
        ventas[9] = new Venta("Afedo",777);
        
        
        int ganador = Concurso.obtenerGanador(ventas);        
        System.out.println(ventas[ganador].toString());
    }
    
}
