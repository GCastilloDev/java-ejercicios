package NivelAvanzado;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TraductorGooglerense {

    public static void main(String[] args) {

        char googlerense[] = {'y', 'n', 'f', 'i', 'c', 'w', 'l', 'b', 'k', 'u', 'o', 'm', 'x', 's', 'e', 'v', 'z', 'p', 'd', 'r', 'j', 'g', 't', 'h', 'a', 'q', ' '};

        Scanner n = new Scanner(System.in);
        System.out.print("Casos: ");
        int casos = n.nextInt();
        n.nextLine();

        while (casos < 1 || casos > 30) {
            System.out.println("Debe de ingresar un número válido de casos, entre 1 y 30");
            System.out.print("Casos: ");
            casos = n.nextInt();
            n.nextLine();
        }

        String cadenas[] = new String[casos];

        for (int i = 0; i < cadenas.length; i++) {
            System.out.print("Ingresa el texto [" + (i + 1) + "]: ");
            cadenas[i] = n.nextLine();
            boolean next = esValido(cadenas[i]);
           
            while (next == false) {
                System.out.println("La frase solo puede contener una o más palabras que contengas las letras de la \'a\' a la \'z\'");
                System.out.print("Ingresa el texto [" + (i + 1) + "]: ");
                cadenas[i] = n.nextLine();
                next = esValido(cadenas[i]);
            }

            while (cadenas[i].charAt(0) == ' ' || cadenas[i].charAt(cadenas[i].length() - 1) == ' ') {
                System.out.println("La frase no puede contener espacios ni al principio ni al final, introduce de nuevo tu frase.");
                System.out.print("Ingresa el texto [" + (i + 1) + "]: ");
                cadenas[i] = n.nextLine();
            }

            while (cadenas[i].length() > 100) {
                System.out.println("La frase no puede contener mas de 100 carácteres.");
                System.out.print("Ingresa el texto [" + (i + 1) + "]: ");
                cadenas[i] = n.nextLine();
            }
        }

        System.out.println("");
        for (int i = 0; i < cadenas.length; i++) {
            String frase = cadenas[i].toLowerCase();
            String traduccion = "";
            for (int j = 0; j < frase.length(); j++) {
                int posicion = 0;
                for (int k = 0; k < googlerense.length; k++) {
                    int espacio = frase.charAt(i);
                    if (frase.charAt(j) == googlerense[k]) {
                        if (k == 26) {
                            traduccion += " ";
                        } else {
                            posicion = k + 97;
                            char letra = (char) posicion;
                            traduccion += letra;
                        }
                    }
                }
            }
            System.out.println("Caso #" + (i + 1) + ": " + traduccion);
        }
    }

    static boolean esValido(String frase) {
        String fraseAuxiliar = frase.toLowerCase();
        boolean esValido = false;
        for (int i = 0; i < fraseAuxiliar.length(); i++) {
                int a = fraseAuxiliar.charAt(i);
                if(fraseAuxiliar.charAt(i) == 32 || ( fraseAuxiliar.charAt(i) > 96 && fraseAuxiliar.charAt(i) < 124 ) ){
                    esValido = true;  
                }else{
                    esValido = false;
                }                        
        }
        return esValido;
    }
}