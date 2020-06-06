package Interfaces.Ejercicio001;

/**
 *
 * @author gustavo
 */
public class Circulo implements IOperacion{    
    
    private float radio;
    
    public Circulo(float radio){
        this.radio = radio;
    }

    @Override
    public float getArea() {
        return PI*radio*radio;
    }

    @Override
    public float getPerimetro() {
        return PI*radio;
    }
    
}
