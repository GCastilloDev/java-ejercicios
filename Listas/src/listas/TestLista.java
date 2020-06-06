package listas;

import java.util.ArrayList;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TestLista {

    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Orlando");
        nombres.add("Yosiel");
        nombres.add("Marco");
        nombres.add("Pablo");
        nombres.add("Jorge");
        Lista.imprimirLista(nombres);
        nombres.set(1, "Luis Miguel");
        Lista.imprimirLista(nombres);
        nombres.remove(3);
        Lista.imprimirLista(nombres);
        System.out.println(nombres.contains("Orlando"));
        System.out.println(nombres.isEmpty());

    }

}
