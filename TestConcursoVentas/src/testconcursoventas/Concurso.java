
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testconcursoventas;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Concurso {
    
     public static int obtenerGanador(Venta[] venta){
        int posicion = 0;
        int cantidad = venta[0].getCantidad();
        
        for (int i = 0; i < venta.length; i++) {            
            if(venta[i].getCantidad() > cantidad){
                posicion = i;
                cantidad = venta[i].getCantidad();
            }
        }               
        return posicion;
    }

}
