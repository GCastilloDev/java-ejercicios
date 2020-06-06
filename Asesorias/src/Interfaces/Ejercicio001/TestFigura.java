package Interfaces.Ejercicio001;

/**
 *
 * @author gustavo
 */
public class TestFigura {

    public static void main(String[] args) {

        IOperacion figura;

        figura = new Circulo(10);
        System.out.println("CIRCULO");
        System.out.println("El área es: " + figura.getArea());
        System.out.println("El perímetro es: " + figura.getPerimetro());
        System.out.println("-----------------------------------------------------");

        figura = new Cuadrado(10);
        System.out.println("CUADRADO");
        System.out.println("El área es: " + figura.getArea());
        System.out.println("El perímetro es: " + figura.getPerimetro());
        System.out.println("-----------------------------------------------------");

        figura = new Rectangulo(20, 10);
        System.out.println("RECTANGULO");
        System.out.println("El área es: " + figura.getArea());
        System.out.println("El perímetro es: " + figura.getPerimetro());

    }

}
