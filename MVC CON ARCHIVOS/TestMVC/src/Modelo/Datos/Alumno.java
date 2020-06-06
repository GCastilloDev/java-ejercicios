package Modelo.Datos;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Alumno {

    private String matricula;
    private String nombre;
    private String apellidos;
    private char genero;
    private Carrera carrera;
    private Contacto contacto;
    private Direccion direccion;


    public Alumno() {
   }

    public Alumno(String matricula, String nombre, String apellidos, char genero, Carrera carrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.carrera = carrera;

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Alumno{" + "matricula=" + matricula + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero + ", carrera=" + carrera + ", contacto=" + contacto + ", direccion=" + direccion + '}';
    }
    
    

}
