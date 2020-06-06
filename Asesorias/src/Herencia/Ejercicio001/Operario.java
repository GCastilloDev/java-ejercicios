package Herencia.Ejercicio001;

/**
 *
 * @author gustavo
 */
public class Operario extends Empleado{
    
    @Override
    public String toString(){
        return "Hola " + super.getNombre() + " eres un operario.";
    }
    
}
