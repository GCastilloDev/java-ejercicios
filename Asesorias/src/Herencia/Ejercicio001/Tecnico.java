package Herencia.Ejercicio001;

/**
 *
 * @author gustavo
 */
final class Tecnico extends Operario{
    
    public String toString(){
        return "Hola " + super.getNombre() + " eres un técnico.";
    }
    
}
