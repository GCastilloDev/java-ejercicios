package listas;

import java.util.ArrayList;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Lista {

    /*
    Sintaxis para declarar una Lista
    ArrayList NombreLista = new ArrayList();
    ArrayList <TipoDato> NombreLista = new ArrayList<>();
     */
    
    ArrayList ejemploLista = new ArrayList();
    ArrayList<String> nombres = new ArrayList<>();
    
    /*
    nombrelista.dd(dato);
    */
    
    static void imprimirLista(ArrayList lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Elemento [" + (i+1) + "]: " + lista.get(i));
        }
        System.out.println("--------------------------------------");
    }
    
}
