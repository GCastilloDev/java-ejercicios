package testTemperatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class MetodosSueltos {

    public static List<Dias> llenarLista(Scanner n) {
        
        
        List <Dias> temperaturas = new ArrayList();
        int diaComienzo = 1;
        
        for (int i = 0; i < 10; i++) {
            Dias dias = new Dias();
            dias.setDia(obtenerDiaString(diaComienzo));
            diaComienzo = obtenerDia(diaComienzo);
            dias.setSemana((int) (i/7) + 1);
            System.out.print("Ingresa la temperatura del " + dias.getDia() +
                    " de la Semana " + dias.getSemana() + ": ");
            dias.setGrados(n.nextInt());
            temperaturas.add(dias);
        }

        return temperaturas;
    }
    
    public static void imprimirLista(List<Dias> temperaturas){
        for (int i = 0; i < temperaturas.size(); i++) {
            System.out.println(temperaturas.get(i).toString());
        }
    }

    public static String obtenerDiaString(int dia) {
        switch (dia) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miércoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sábado";
            case 7:
                return "Domingo";
            default:
                return "Día inválido";
        }
    }

    public static int obtenerDia(int dia) {
        switch (dia) {
            case 1:
                return dia+1;
            case 2:
                return dia+1;
            case 3:
                return dia+1;
            case 4:
                return dia+1;
            case 5:
                return dia+1;
            case 6:
                return dia+1;
            case 7:
                return 1;
            default:
                return 0;
        }
    }
    
    public static void diasMasCalurosos(List<Dias> temperaturas){
        for (int i = 0; i < temperaturas.size(); i++) {
            
            if(temperaturas.get(0).getGrados() == temperaturas.get(i).getGrados()){
            System.out.println(temperaturas.get(i).toString());
            }
            
        }
    }
    
    public static float temperaturaMediaMes(List<Dias> temperaturas){
        int total = 0;
        
        for (int i = 0; i < temperaturas.size(); i++) {
            total += temperaturas.get(i).getGrados();
        }
        
        return total/10;
    }

}
