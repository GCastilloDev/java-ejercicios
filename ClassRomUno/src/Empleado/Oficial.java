package Empleado;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Oficial extends Operario {

    public Oficial(String nombre) {
        super(nombre);
    }
    
    @Override
    public String toString(){
        return "Empleado " + super.getNombre() + " -> Operario -> Oficial";
    }

}
