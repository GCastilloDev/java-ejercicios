package testTemperatura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class testTemperatura {

    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);
        List<Dias> temperaturas = new ArrayList();
        boolean next = true;

        while (next == true) {
            System.out.println("========<MENU TEMPERATURAS CHI>========");
            System.out.println("(1) Rellenar las temperaturas.");
            System.out.println("(2) Mostrar las temperaturas.");
            System.out.println("(3) Visualizar la temperatura media del mes.");
            System.out.println("(4) Día o días más calurosos del mes.");
            System.out.println("(5) Salir");
            System.out.println("¿Que opción desea?");
            int opcion = n.nextInt();

            switch (opcion) {
                case 1:
                    temperaturas = MetodosSueltos.llenarLista(n);
                    break;
                case 2:
                    if (temperaturas.size() > 0) {
                        MetodosSueltos.imprimirLista(temperaturas);
                        System.out.println("¿Desea regresar al menú? (1)Si (2)No");
                        opcion = n.nextInt();
                        if (opcion == 2) {
                            next = false;
                        }
                    } else {
                        System.out.println("La lista se encuentra vacía.");
                        System.out.println("¿Desea regresar al menú? (1)Si (2)No");
                        opcion = n.nextInt();
                        if (opcion == 2) {
                            next = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Temperatura media del mes:");
                    System.out.println(MetodosSueltos.temperaturaMediaMes(temperaturas));
                    System.out.println("¿Desea regresar al menú? (1)Si (2)No");
                    opcion = n.nextInt();
                    if (opcion == 2) {
                        next = false;
                    }
                    break;
                case 4:
                    Collections.sort(temperaturas, Collections.reverseOrder());
                    MetodosSueltos.diasMasCalurosos(temperaturas);
                    System.out.println("¿Desea regresar al menú? (1)Si (2)No");
                    opcion = n.nextInt();
                    if (opcion == 2) {
                        next = false;
                    }
                    break;
                default:
                    next = false;
                    break;
            }
        }
    }
}
