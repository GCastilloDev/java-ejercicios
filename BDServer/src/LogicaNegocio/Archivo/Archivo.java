/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocio.Archivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author @LastShadow
 */
public class Archivo {
    
    public boolean crearCarpeta(String nombreBD){
        File carpeta = new File("basededatos/" + nombreBD);
        if(carpeta.exists()){
            return false;
//            System.err.println("Base de datos \"" + nombreBD + "\" ya existe.");
        }else{
            carpeta.mkdirs();
            return true;
//            System.out.println("Base de datos \"" + nombreBD + "\" creada con éxito.");
        }        
    }
    
    public boolean guardarObjeto(ArrayList<String> tabla, String nombreBD, String nombreTabla) {
        try {
            ObjectOutputStream guardarFlujoObjeto;
//            System.out.println("Guardar objeto " + nombreArchivo);
            guardarFlujoObjeto = new ObjectOutputStream(new FileOutputStream("basededatos/" + nombreBD + "/" + nombreTabla + ".txt"));
            guardarFlujoObjeto.writeObject(tabla);
            guardarFlujoObjeto.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Error guardar: " + ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<String> leerObjeto(String nombreBD, String nombreTabla){
        File archivo = new File("basededatos/" + nombreBD + "/" + nombreTabla + ".txt");
        ArrayList<String> tabla = new ArrayList<>();
        try {            
            
            ObjectInputStream leerObjeto;
            leerObjeto = new ObjectInputStream(new FileInputStream(archivo));
            tabla = (ArrayList) leerObjeto.readObject();   
            leerObjeto.close();            
        } catch (IOException ex) {
            System.out.println("Leer información (1) Error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return tabla;
    }
    
    
    

    public static void main(String[] args) {
        Archivo a = new Archivo();
        
//        for (int i = 0; i < a.tablas("morita").size(); i++) {
//            System.out.println(a.tablas("morita").get(i));
//        }

        for (int i = 0; i < a.leerObjeto("morita","morita").size(); i++) {
            System.out.println(a.leerObjeto("morita","morita").get(i));
        }
    }
}
