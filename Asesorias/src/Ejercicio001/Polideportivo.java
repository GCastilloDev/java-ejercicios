package Ejercicio001;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Polideportivo extends Edificio implements IEdificio , IInstalacion{
    
    private String nombre;
    
    public Polideportivo (double superficie, String nombre){
        super(superficie);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public double getSuperficie() {
        return super.getSuperficie();
    }

    @Override
    public int getTipoDeInstalacion() {
        return 1;
    }
    
    @Override
    public String toString(){
        return "\nNombre del edificio: " + this.getNombre() + " superficie: " + this.getSuperficie() + "  tipo de instalación: " + this.getTipoDeInstalacion();
    }

}
