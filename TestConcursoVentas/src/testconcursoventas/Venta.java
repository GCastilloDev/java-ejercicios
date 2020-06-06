package testconcursoventas;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Venta {
    
    private String nombre;
    private int cantidad;

    public Venta(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        return "El ganador es: " + this.getNombre() + " con " + this.getCantidad() + " unidades vendidas.";
    }
}
