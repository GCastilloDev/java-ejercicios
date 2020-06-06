package Herencia.Ejercicio001;

/**
 *
 * @author gustavo
 */
public class TestEmpleado {
    
    public static void main(String[] args) {
        
        Empleado empleado = new Empleado();
        empleado.setNombre("Gustavo");
        System.out.println(empleado.toString());
        
        empleado = new Directivo();
        empleado.setNombre("Gustavo");
        System.out.println(empleado.toString());
        
        empleado = new Operario();
        empleado.setNombre("Gustavo");
        System.out.println(empleado.toString());
        
        
        Operario operario = new Operario();
        
        operario.setNombre("Gustavo");
        System.out.println(operario.toString());
        
        operario = new Oficial();
        operario.setNombre("Gustavo");
        System.out.println(operario.toString());
        
        operario = new Tecnico();
        operario.setNombre("Gustavo");
        System.out.println(operario.toString());
        
        
    }
    
}
