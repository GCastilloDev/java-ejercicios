package testconsecionaria;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Ventas {
    
    private double montoVenta;
    private int vehiculoVendido;
    private String apellido;
    private String nombre;
    private int ciComprador;

    //Constuctor de la clase con sobre carga.
    public Ventas(Vehiculo vehiculo, double montoVenta, String apellido, String nombre, int ciComprador) {
        this.montoVenta = montoVenta;
        this.vehiculoVendido = vehiculo.getCodigo();
        this.apellido = apellido;
        this.nombre = nombre;
        this.ciComprador = ciComprador;
    }
    
    //Constructor de la clase por defecto y/o sin parametros.
    public Ventas(){
        
    }

    /**
     * Método que me devuelve el monto de la venta.
     * @return 
     */
    public double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    }

    public int getVehiculoVendido() {
        return vehiculoVendido;
    }

    public void setVehiculoVendido(int vehiculoVendido) {
        this.vehiculoVendido = vehiculoVendido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiComprador() {
        return ciComprador;
    }

    public void setCiComprador(int ciComprador) {
        this.ciComprador = ciComprador;
    }
    
    @Override
    public String toString(){
        return "Monto de la venta $" + this.getMontoVenta() +
                "\nVehículo vendido: " + this.getVehiculoVendido() + 
                "\nApellido: " + this.getApellido() + 
                "\nNombre: " + this.getNombre() + 
                "\nCI: " + this.ciComprador;
    }

    
}
