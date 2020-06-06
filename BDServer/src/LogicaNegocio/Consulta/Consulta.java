/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio.Consulta;

import LogicaNegocio.Archivo.Archivo;
import java.util.ArrayList;

/**
 *
 * @author @LastShadow
 */
public class Consulta {

    Archivo a = new Archivo();

    public boolean crearBD(String nombreBD) {
        return a.crearCarpeta(nombreBD);
    }

    public boolean crearTabla(ArrayList<String> tabla, String nombreBD, String nombreTabla, String campos) {
        return a.guardarObjeto(tabla, nombreBD, nombreTabla);
    }

    public String consultarTabla(String nombreBD, String condicion, String nombreTabla) {
        ArrayList<String> tabla = a.leerObjeto(nombreBD, nombreTabla);
        String mensaje = "";

        mensaje += "Base de datos: " + nombreBD;
        mensaje += "\nTabla consultada: " + nombreTabla;
        mensaje += "\n" + tabla.get(0);
        mensaje += "\n=============================================";

        if (condicion.equals("*")) {

            if (tabla.size() > 1) {
                for (int i = 1; i < tabla.size(); i++) {
                    mensaje += "\n" + tabla.get(i);
//                     System.out.println(tabla.get(i));
                }
            } else {
                mensaje += "\nLA TABLA NO CONTIENE REGISTROS";
            }
        } else {
            
            String[] condicionDivida = condicion.split("=");
            
           
            
            String[] camposDivididos = tabla.get(0).split(",");
            
//             for (int i = 0; i < camposDivididos.length; i++) {
//                System.out.println(camposDivididos[i]);
//            }

            boolean existeCampo = false;            
            int posicionDelCampo = -1;

            for (int i = 0; i < camposDivididos.length; i++) {
                if (camposDivididos[i].equalsIgnoreCase(condicionDivida[0])) {
                    existeCampo = true;
                    posicionDelCampo = i;
                    break;
                }
            }
           
            if (existeCampo) {
//                System.out.println("existe campo");
                if (tabla.size() > 1) {
                    
                    
//                    String [] a = tabla.get(1).split(",");
//                    System.out.println(a[posicionDelCampo]);  
             
                    
                    for (int i = 1; i < tabla.size(); i++) {
                        
                        String [] a = tabla.get(i).split(",");
                        if(a[posicionDelCampo].equalsIgnoreCase(condicionDivida[1])){
                            mensaje += "\n" + tabla.get(i);
//                            System.out.println(tabla.get(i));
                        }                                               
                    }
                } else {
                    mensaje += "\nLA TABLA NO CONTIENE REGISTROS QUE CUMPLAN LA CONDICION";
                }
            }

        }
        return mensaje;
    }
    
    public String agregar(String nombreBD, String nombreTabla, String campos){
        ArrayList<String> temp = a.leerObjeto(nombreBD, nombreTabla);
        temp.add(campos);
        a.guardarObjeto(temp, nombreBD, nombreTabla);
        return "# REGISTROS AGREGADOS CON EXITO";
    }

    public static void main(String[] args) {
        Consulta c = new Consulta();
        System.out.println("hola");
        System.out.println(c.consultarTabla("morita", "*", "morita"));
        System.out.println("===================================================");
        System.out.println(c.agregar("morita", "morita", "orlando,morales"));
        System.out.println(c.consultarTabla("morita", "*", "morita"));
        System.out.println("===================================================");
    }
}
