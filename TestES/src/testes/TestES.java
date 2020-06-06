package testes;
import java.io.*;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TestES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int leer;
        int contador = 0;
        
        while ( (leer = System.in.read()) != '\n') {
            contador++;
            System.out.print(leer);
        }
        System.out.println("");
        System.out.println("Bytes leidos " + contador);
    }
    
}
