package Unidad1.TestTiempo;

/**
 *
 * @author gustavo
 */
public class TestTiempo {
    
    public static void main(String[] args) {
        
        //OBJETO: hora, hora1, hora2, etc...
        //Constructor por defecto
        Tiempo hora = new Tiempo();
        Tiempo hora2 = new Tiempo(13);
        Tiempo hora3 = new Tiempo(23,12);
        Tiempo hora4 = new Tiempo(22,10,55);
        
        System.out.println(hora.getHora() + ":" + hora.getMinuto() + ":" + hora.getSegundo());
        System.out.println(hora2.getHora() + ":" + hora2.getMinuto() + ":" + hora2.getSegundo());
        System.out.println(hora3.getHora() + ":" + hora3.getMinuto() + ":" + hora3.getSegundo());
        System.out.println(hora4.getHora() + ":" + hora4.getMinuto() + ":" + hora4.getSegundo());

        hora.setHora(13);
        hora.setMinuto(13);
        hora.setSegundo(43);
        
        System.out.println(hora.getHora() + ":" + hora.getMinuto() + ":" + hora.getSegundo());
        
    }
    
}
