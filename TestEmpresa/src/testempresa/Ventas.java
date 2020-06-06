package testempresa;

import java.util.List;


public class Ventas {
   
    public static double gananciaVentas(List <Double> lista){
        double suma = 0;
                
        for (int i = 0; i < lista.size(); i++) {
            suma+= lista.get(i);
        }
        
        return suma * 0.09;
    }
    
        public static double sumaVentas(List <Double> lista){
        double suma = 0;
                
        for (int i = 0; i < lista.size(); i++) {
            suma+= lista.get(i);
        }
        
        return suma;
    }

}
