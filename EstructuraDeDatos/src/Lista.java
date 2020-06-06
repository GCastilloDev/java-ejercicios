
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Lista {

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        
        for (Integer list : lista) {
            System.out.println(list);
        }
        
        lista.remove(1);
        System.out.println("");
                for (Integer list : lista) {
            System.out.println(list);
        }
        
                System.out.println("indice: " +lista.lastIndexOf(52));
    }

}
