package Modelo.Archivo;

import Modelo.Datos.Alumno;
import Modelo.Datos.Carrera;
import Modelo.Datos.Contacto;
import Modelo.Datos.Direccion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class ArchivoDatos {

    private File archivo;

    public ArchivoDatos(String nombreArchivo) {
        this.archivo = new File(nombreArchivo + ".txt");
    }

    public void eliminarDatos(String nombreArchivo){
        this.archivo = new File("Archivos/" + nombreArchivo + ".txt");
        archivo.delete();
    }
    
    public void guardarDatos(Alumno alumno) {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("Archivos/" + this.archivo));
            salida.write(alumno.getMatricula() + "\n");
            salida.write(alumno.getNombre() + "\n");
            salida.write(alumno.getApellidos() + "\n");
            salida.write(alumno.getGenero() + "\n");

            salida.write(alumno.getCarrera().getId() + "\n");
            salida.write(alumno.getCarrera().getNombre() + "\n");

            salida.write(alumno.getDireccion().getCalle() + "\n");
            salida.write(alumno.getDireccion().getCiudad() + "\n");
            salida.write(alumno.getDireccion().getColonia() + "\n");
            salida.write(alumno.getDireccion().getCp() + "\n");
            salida.write(alumno.getDireccion().getEstado() + "\n");

            salida.write(alumno.getContacto().getCorreo() + "\n");
            salida.write(alumno.getContacto().getFacebook() + "\n");
            salida.write(alumno.getContacto().getNumCelular() + "\n");
            salida.write(alumno.getContacto().getNumFijo() + "\n");
            salida.write(alumno.getContacto().getTwitter() + "\n");

            salida.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        } finally {
            try {
                salida.close();
            } catch (IOException ex) {
                Logger.getLogger(ArchivoDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<Alumno> cargarDatos() {
        File directorio = new File("Archivos");
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
        Alumno alumno;
        
        if(directorio.isDirectory()){
            for (String list : directorio.list()) {
                alumno = leerInformacionAlumno(list);
                listaAlumnos.add(alumno);
            }
        }        
        return listaAlumnos;
    }
    
    private static Alumno leerInformacionAlumno(String nombreArchivo){
        File archivo =  new File("Archivos/" + nombreArchivo);
        Alumno alumno = new Alumno();
        try {
            FileReader archivoModoLectura = new FileReader(archivo);
            BufferedReader bufferLectura = new BufferedReader(archivoModoLectura);
            alumno.setMatricula(bufferLectura.readLine());
            alumno.setNombre(bufferLectura.readLine());
            alumno.setApellidos(bufferLectura.readLine());
            alumno.setGenero(bufferLectura.readLine().charAt(0));
            alumno.setCarrera(new Carrera(Integer.parseInt(bufferLectura.readLine()), bufferLectura.readLine()));
            
            Direccion d = new Direccion();
            d.setCalle(bufferLectura.readLine());
            d.setCiudad(bufferLectura.readLine());
            d.setColonia(bufferLectura.readLine());
            d.setCp(bufferLectura.readLine());
            d.setEstado(bufferLectura.readLine());
            alumno.setDireccion(d);
            
            Contacto c = new Contacto();
            c.setCorreo(bufferLectura.readLine());
            c.setFacebook(bufferLectura.readLine());
            c.setNumCelular(bufferLectura.readLine());
            c.setNumFijo(bufferLectura.readLine());
            c.setTwitter(bufferLectura.readLine());
            alumno.setContacto(c);
            
        } catch (FileNotFoundException ex) {
            System.out.println("1.- Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("2.- Error: " + ex.getMessage());
        }
        
        return alumno;
    }
    
    public ArchivoDatos(){}
    
    public static void main(String[] args) {
        ArchivoDatos a = new ArchivoDatos();                
        
        for (Alumno cargarDato : a.cargarDatos()) {
            System.out.println(cargarDato);
        }
        
    }
}