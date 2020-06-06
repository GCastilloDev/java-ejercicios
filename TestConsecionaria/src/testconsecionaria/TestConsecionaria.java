package testconsecionaria;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TestConsecionaria {


    public static void main(String[] args) {

        Ventas ventas[] = new Ventas[3];

        Vehiculo vehiculo = new Vehiculo();
        Ventas venta = new Ventas();

        vehiculo = new Motocicletas(10, "Suzuki", "Motocicleta", 2010, "Patente1020", 500);
        venta = new Ventas(vehiculo, 35500.99, "Hernandez", "Gonzalez", 500);
        ventas[0] = venta;

        vehiculo = new Autos(2, "Chevrolet", "Auto", 2015, "Patente1010", 250500);
        venta = new Ventas(vehiculo, 145599.99, "Castillo", "Gustavo", 55897713);
        ventas[1] = venta;

        vehiculo = new Camionetas(15, "Ford", "Camioneta", 2010, "Patente1120", 8800);
        venta = new Ventas(vehiculo, 1000000, "Macario", "Luis", 5556800);
        ventas[2] = venta;
        
        System.out.println("Ventas Realizadas");
        System.out.println("");
        System.out.println(ventas[0].toString());
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(ventas[1].toString());
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(ventas[2].toString());

    }

}
