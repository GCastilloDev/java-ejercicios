package Ejercicio001;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class EdificioOficinas
        extends Edificio implements IEdificio {

    private int numeroOficinas;

    public EdificioOficinas(double superficie, int numeroOficinas) {
        super(superficie);
        this.numeroOficinas = numeroOficinas;
    }

    @Override
    public double getSuperficie() {
        return super.getSuperficie();
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    public void setNumeroOficinas(int numeroOficinas) {
        this.numeroOficinas = numeroOficinas;
    }
    
    @Override
    public String toString(){
        return "\nNúmero de oficinas: " + this.getNumeroOficinas() + " superficie: " + this.getSuperficie();
    }

}
