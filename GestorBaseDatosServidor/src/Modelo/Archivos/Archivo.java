/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Archivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 
 * @author @LastShadow
 */
public class Archivo {
    
    private static Archivo archivo = null;
    
    
    private Archivo(){
        
    }
    
    public static Archivo getArchivo(){
        if (archivo == null){
            return new Archivo();
        }else{
            return archivo;
        }
    }
    
    
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
    
    public void eliminarCarpeta(String nombreBD, String nombreTabla){
        File archivo = new File("basesdedatos/"+nombreBD+"/"+nombreTabla+".txt");
        if(archivo.exists()){
//            System.out.println("Existe el archivo");
            archivo.delete();
            System.out.println("Tabla borrada con éxito.");
        }
    }
    
    public void crearArchivo(ArrayList<Object> tabla, String nombreBD, String nombreTabla){
        try {
            ObjectOutputStream guardarObjeto;
            System.out.println("Guardar objeto " + nombreTabla);
            System.out.println("Nombre bd " + nombreBD);            
            String ruta = "basededatos/" + nombreBD + "/";
//            System.out.println(ruta);
            guardarObjeto = new ObjectOutputStream(new FileOutputStream(ruta + nombreTabla + ".txt"));
            guardarObjeto.writeObject(tabla);
            guardarObjeto.close();
        } catch (IOException ex) {
            System.err.println("Error guardar: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Archivo().eliminarCarpeta("prueba2", "Orlando");
    }

}
