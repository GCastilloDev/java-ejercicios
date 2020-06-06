
package Herencia.Ejercicio001;

/**
 *
 * @author gustavo
 */

public class Empleado {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    
    @Override
    public String toString(){
        return "Hola " + this.nombre;
    }
    
}
