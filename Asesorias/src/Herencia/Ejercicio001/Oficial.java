package Herencia.Ejercicio001;

/**
 *
 * @author gustavo
 */
final class Oficial extends Operario{

    @Override
    public String toString(){
       return "Hola " + super.getNombre() + " eres un oficial.";
    }
}
