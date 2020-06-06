package Empleado;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Tecnico extends Operario{

    public Tecnico(String nombre) {
        super(nombre);
    }

    @Override
    public String toString(){
        return "Empleado " + super.getNombre() + " -> Operario -> Tecnico";
    }
}
