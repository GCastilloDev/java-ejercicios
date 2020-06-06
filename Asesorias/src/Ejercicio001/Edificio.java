package Ejercicio001;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Edificio {

    private double superficie;

    public Edificio(double superficie){ 
        this.superficie = superficie;
    }
    
    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    
    @Override
    public String toString(){
        return "\nSuperficie: " + this.getSuperficie();
    }
}
