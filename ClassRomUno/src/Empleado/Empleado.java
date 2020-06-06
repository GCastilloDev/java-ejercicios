package Empleado;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Empleado {
    
    public Empleado(){
        
    }
    
    public Empleado (String nombre){
        this.nombre = nombre;
    }
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "Empleado " + getNombre();
    }
    

}
