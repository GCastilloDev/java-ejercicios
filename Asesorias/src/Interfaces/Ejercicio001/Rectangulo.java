package Interfaces.Ejercicio001;

/**
 *
 * @author gustavo
 */
public class Rectangulo implements IOperacion{
    
    private float base;
    private float altura;

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }
    
    
    @Override
    public float getArea() {
        return this.base * this.altura;
    }

    @Override
    public float getPerimetro() {
        return 2 * (this.base + this.altura);
    }
    
    
    
}
