package Herencia.Ejercicio001;

/**
 *
 * @author gustavo
 */
final class Directivo extends Empleado{
    
    public String toString(){
        return "Hola " + super.getNombre() + " eres un directivo.";
    }
    
}
