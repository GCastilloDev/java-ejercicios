package testteatro;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Funcion{
    
    private String nombreFuncion;
    private double precioFuncion;
    private String nombreTeatro;
    private String direccionTeatro;
    private static Funcion funcion;
    
    Teatro teatro = Teatro.getTeatro();
    
    private Funcion() {
    }    
   
    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public double getPrecioFuncion() {
        return precioFuncion;
    }

    public void setPrecioFuncion(double precioFuncion) {
        this.precioFuncion = precioFuncion;
    }

    public String getNombreTeatro() {
        return teatro.getNombreTeatro();
    }

    public void setNombreTeatro(String nombreTeatro) {
        teatro.setNombreTeatro(nombreTeatro);
    }

    public String getDireccionTeatro() {
        return teatro.getDireccionTeatro();
    }

    public void setDireccionTeatro(String direccionTeatro) {
        teatro.setDireccionTeatro(direccionTeatro);
    }
       
    public static Funcion getFuncion(){
        if(funcion == null){
            return funcion = new Funcion();
        }
        return funcion;
    }
       

    @Override
    public String toString() {
        return "Teatro: " + teatro.getNombreTeatro() +
                "\nDirección: " + teatro.getDireccionTeatro() +
                "\nFunción: " + this.getNombreFuncion() +
                "\nPrecio: $" + this.getPrecioFuncion() +
                "-------------------------------------------------------------------------------";
    }

    
    

}
