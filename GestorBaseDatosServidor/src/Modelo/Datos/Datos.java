/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author @LastShadow
 */
public class Datos implements Serializable {
    
    ArrayList<Object> tabla;
    String comando;
    
    public Datos(ArrayList<Object> tabla, String comando){
        this.tabla = tabla;
        this.comando = comando;
    }

    public ArrayList<Object> guardarDatos() {
        int numeroCampos = (int) tabla.get(1);
        String c = "";
        for (int i = 0; i < comando.length(); i++) {
            if (comando.charAt(i) == '(' && comando.charAt(comando.length() - 1) == ')') {
//                System.out.println("Entro a descomposicion de cadena");
                for (int j = i + 1; j < comando.length() - 1; j++) {
                    c += comando.charAt(j);
                }
                break;
            }
        }
        String campos[] = c.split(",");

        if (campos.length == numeroCampos) {
            tabla.add(c);
        } else {
            System.err.println("Número de campos esperados " + numeroCampos + ".");
            System.err.println("Campos recibidos " + campos.length + ".");
        }

        return tabla;
    }

    public static void main(String[] args) {
        
        ArrayList<Object> tabla = new ArrayList<>();
        tabla.add("Orlando");
        tabla.add(2);
        tabla.add("nombre,apellido");
        System.out.println("Lista original");
        for (int i = 0; i < tabla.size(); i++) {
            System.out.print(tabla.get(i) + " ");
        }
        System.out.println("");
        Datos datos = new Datos(tabla, "AGREGAR Orlando VALOR (gustavo,castillo najera)");
        tabla = datos.guardarDatos();
        System.out.println("Lista nueva");
        for (int i = 0; i < tabla.size(); i++) {
            System.out.println(tabla.get(i));
        }
    }

}
