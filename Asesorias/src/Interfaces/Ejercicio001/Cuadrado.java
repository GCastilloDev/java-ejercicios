package Interfaces.Ejercicio001;

/**
 *
 * @author gustavo
 */
public class Cuadrado implements IOperacion{

    private float lado;

    public Cuadrado(float lado) {
        this.lado = lado;
    }
       
    
    @Override
    public float getArea() {
        return this.lado * this.lado;
    }

    @Override
    public float getPerimetro() {
        return 4 * this.lado;
    }
    
}
