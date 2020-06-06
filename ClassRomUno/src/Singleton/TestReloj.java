package Singleton;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TestReloj {

    public static void main(String[] args) {

        Reloj hora = Reloj.getReloj();

        hora.start();
    }

}
