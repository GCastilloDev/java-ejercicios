package concursohola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class ConcursoHola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);

        System.out.println("Ingrese la frase: ");
        String frase = n.nextLine();
        int contador = 0;
        
        for (int i = 0; i < frase.length(); i++) {
            if(frase.charAt(i) == 'h' || frase.charAt(i) == 'H'){
                for (int j = i + 1; j < frase.length(); j++) {
                    if(frase.charAt(j) == 'o' || frase.charAt(i) == 'O'){
                        System.out.println("entro o");
                        for (int k = j + 1; k < frase.length(); k++) {
                            if(frase.charAt(k) == 'l' || frase.charAt(i) == 'L'){
                                for (int l = k + 1; l < frase.length(); l++) {
                                    if(frase.charAt(l) == 'a' || frase.charAt(i) == 'A'){
                                        contador++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("contador " + contador);

//        //Contar h, o, l, a
//        int tamH = 0;
//        int tamO = 0;
//        int tamL = 0;
//        int tamA = 0;
//
//        List<Integer> posicionesH = new ArrayList();
//        List<Integer> posicionesO = new ArrayList();
//        List<Integer> posicionesL = new ArrayList();
//        List<Integer> posicionesA = new ArrayList();
//
//        for (int i = 0; i < frase.length(); i++) {
//
//            if (frase.charAt(i) == 'h' || frase.charAt(i) == 'H') {
//                tamH++;
//                posicionesH.add(i);
//            }
//            if (frase.charAt(i) == 'o' || frase.charAt(i) == 'O') {
//                tamO++;
//                posicionesO.add(i);
//            }
//            if (frase.charAt(i) == 'l' || frase.charAt(i) == 'L') {
//                tamL++;
//                posicionesL.add(i);
//            }
//            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'A') {
//                tamA++;
//                posicionesA.add(i);
//            }
//        }
//        
//        int contador = 0;
//        for (int i = 0; i < frase.length(); i++) {
//            if(frase.charAt(i) == 'h' || frase.charAt(i) == 'H'){
//                for (int j = i; j < frase.length(); j++) {
//                    if(frase.charAt(j) == 'o' || frase.charAt(j) == 'O'){
//                        
//                    }
//                    
//                }
//            }
//        }

//        int contador = 0;
//        int contador2 = 0;
//        int posicionA = 0;
//
//        while (contador2 < posicionesH.size()) {
//            if (posicionesH.get(contador) < posicionesO.get(contador)) {
//                if (posicionesO.get(contador) < posicionesL.get(contador)) {
//                    if (posicionesL.get(contador) < posicionesA.get(posicionA)) {
//                        System.out.println("entrooooooooooooooooooo");
//                    
//                        if(posicionesA.size() > posicionA){
//                            posicionA++;
//                        }else{
//                            contador2++;
//                        }
//                        
//                    } else {
//                        contador2++;
//                        System.out.println("no entrooooooooooo");
//                    }
//                }
//            }
//        }
        
        
//        System.out.println("POSICIONES H");
//        for (int i = 0; i < posicionesH.size(); i++) {
//            System.out.print(posicionesH.get(i) + " ");
//        }
//        System.out.println("");
//        System.out.println("POSICIONES O");
//        for (int i = 0; i < posicionesO.size(); i++) {
//            System.out.print(posicionesO.get(i) + " ");
//        }
//        System.out.println("");
//        System.out.println("POSICIONES L");
//        for (int i = 0; i < posicionesL.size(); i++) {
//            System.out.print(posicionesL.get(i) + " ");
//        }
//        System.out.println("");
//        System.out.println("POSICIONES A");
//        for (int i = 0; i < posicionesA.size(); i++) {
//            System.out.print(posicionesA.get(i) + " ");
//        }

//        System.out.println("H: " + tamH);
//        System.out.println("O: " + tamO);
//        System.out.println("L: " + tamL);
//        System.out.println("A: " + tamA);
//        System.out.println("=================================================");
//        System.out.println(posicionesH.size());
//        System.out.println(posicionesO.size());
//        System.out.println(posicionesL.size());
//        System.out.println(posicionesA.size());
    }

}
