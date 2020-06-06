package testempresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestEmpresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List <String> nombreProducto = new ArrayList<>();
        List <Double> precioProducto = new ArrayList<>();
        
        Scanner leer = new Scanner(System.in);
        int i = 0;
        int siguiente = 0;
        
        
        System.out.println("Ingresa las ventas de la semana");
        System.out.println("");
        
        do {
            
            System.out.print("Ingresa el nombre del producto: ");
            String nombre = leer.nextLine();
            nombreProducto.add(nombre);
            System.out.print("Ingresa el precio del producto " + nombreProducto.get(i) + ": $");
            double precio = leer.nextDouble();
            precioProducto.add(precio);
            i++;
            System.out.print("¿Desea agregar otro producto? Para si presione 1, para no presione 2: ");
            siguiente = leer.nextInt();
            leer.nextLine();
            
        } while (siguiente == 1);
        
        System.out.println("");
        System.out.println("Total de ventas de la semana: $" + Ventas.sumaVentas(precioProducto));
        System.out.println("Tus ingresos de esta semana son $200 de salario fijo más " +
                "$" + Ventas.gananciaVentas(precioProducto) + 
                " de comisión dando un total de $" + (200+Ventas.gananciaVentas(precioProducto)));
    }
    
}
