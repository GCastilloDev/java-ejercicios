package Racional;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TestRacional {

    public static void main(String[] args) {

        Racional objetoA = new Racional();
        Racional objetoB = new Racional();

        Scanner n = new Scanner(System.in);

        System.out.print("Ingresa el numerador de la primera fracción: ");
        objetoA.asignarNumerador(n.nextInt());
        System.out.print("Ingresa el denominador de la primera fracción: ");
        objetoA.asignarDenominador(n.nextInt());

        while (objetoA.getY() == 0) {
            System.out.print("El denominador no puede ser 0, favor de volver a ingresarlo: ");
            objetoA.asignarDenominador(n.nextInt());
        }

        System.out.print("Ingresa el numerador de la segunda fracción: ");
        objetoB.asignarNumerador(n.nextInt());
        System.out.print("Ingresa el denominador de la segunda fracción: ");
        objetoB.asignarDenominador(n.nextInt());

        while (objetoB.getY() == 0) {
            System.out.print("El denominador no puede ser 0, favor de volver a ingresarlo: ");
            objetoB.asignarDenominador(n.nextInt());
        }
        
        
        Racional resultado = objetoA.suma(objetoB);
        System.out.println("Suma: " + resultado);
        
        resultado = objetoA.resta(objetoB);
        System.out.println("Resta: " + resultado);
        
        resultado = objetoA.producto(objetoB);
        System.out.println("Producto: " + resultado);
        
        resultado = objetoA.division(objetoB);
        System.out.println("División: " + resultado);        

        System.out.println("Son iguales: "  + objetoA.esIgual(objetoB));

    }

}
