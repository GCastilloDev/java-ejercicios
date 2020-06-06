package testtrianguloisosceles;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TrianguloIsosceles {

    private double base;
    private double altura;
    private double lado;

    public TrianguloIsosceles() {
    }

    public TrianguloIsosceles(double base, double altura, double lado) {
        this.base = base;
        this.altura = altura;
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

   
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
    calcularArea
    Método que recibe dos parametros de tipo double.
    Los parametros que recibe representan:
    *Base del triángulo
    *Altura del triángulo
    Devuelve el área de un triángulo.
     * @param base
     * @param altura
     * @return 
     */
    public double calcularArea(double base, double altura) {
        return base * altura / 2;
    }

     /**
    calcularPerimetro
    Método que recibe dos parametros de tipo double.
    Los parametros que recibe representan:
    *Base de un triángulo
    *Lado de un triángulo
    Devuelve el perímetro de un triángulo.    
     * @param base
     * @param lado
     * @return 
    */
    public double calcularPerimetro(double base, double lado){    
        return base + ( lado * 2 );
    }

    @Override
    public String toString() {
        return "Triangulo Isosceles \nÁrea: " + calcularArea(base, altura) + "\nPerímetro: " + calcularPerimetro(base, lado);
    }
    
    
}
