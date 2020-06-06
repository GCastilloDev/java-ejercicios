package Racional;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Racional {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void asignarNumerador(int x) {
        this.x = x;
    }

    public void asignarDenominador(int y) {
        this.y = y;
    }

    public Racional suma(Racional b) {
        Racional objeto = new Racional();
        int numerador = 0;
        int denominador = 0;
        
        if(this.getY() == b.getY()){
            
            numerador = this.getX() + b.getX();
            denominador = this.getY();            
        }else{
            denominador = calcularMinimoComunMultiplo(this.getY(), b.getY());
            numerador =( (denominador / this.getY()) * this.getX() ) + ( (denominador / b.getY()) * b.getX() );
        }
        
        
        objeto.asignarNumerador(numerador);
        objeto.asignarDenominador(denominador);

        return objeto;
    }

    public Racional resta(Racional b) {
        Racional objeto = new Racional();
        int numerador = 0;
        int denominador = 0;
        
        if(this.getY() == b.getY()){
            
            numerador = this.getX() - b.getX();
            denominador = this.getY();            
        }else{
            denominador = calcularMinimoComunMultiplo(this.getY(), b.getY());
            numerador =( (denominador / this.getY()) * this.getX() ) - ( (denominador / b.getY()) * b.getX() );
        }
        
        
        objeto.asignarNumerador(numerador);
        objeto.asignarDenominador(denominador);

        return objeto;
    }
    
    public Racional producto(Racional b) {
        Racional objeto = new Racional();
    
        int numerador = this.getX() * b.getX();
        int denominador = this.getY() * b.getY();
        int maximoComunDivisor = calcularMaximoComunDivisor(numerador, denominador);

        
        objeto.asignarNumerador(numerador / maximoComunDivisor);
        objeto.asignarDenominador(denominador / maximoComunDivisor);

        return objeto;
    }
    
    public Racional division(Racional b) {
        Racional objeto = new Racional();
    
        int numerador = this.getX() * b.getY();
        int denominador = b.getX() * this.getY();
        int maximoComunDivisor = calcularMaximoComunDivisor(numerador, denominador);

        
        objeto.asignarNumerador(numerador / maximoComunDivisor);
        objeto.asignarDenominador(denominador / maximoComunDivisor);

        return objeto;
    }
    
    public boolean esIgual(Racional b){
        
        int maximoComunDivisor = calcularMaximoComunDivisor(this.getX(), this.getY());
        int numeradorA = this.getX() / maximoComunDivisor;
        int denominadorA = this.getY() / maximoComunDivisor;
       
        maximoComunDivisor = calcularMaximoComunDivisor(b.getX(), b.getY());
        int numeradorB = b.getX() / maximoComunDivisor;
        int denominadorB = b.getY() / maximoComunDivisor;
        
        return numeradorA == numeradorB && denominadorA == denominadorB;
    }
    
    public int calcularMinimoComunMultiplo(int numA, int numB) {
        int mcm = 0;

        int min = Math.min(numA, numB);

        for (int i = 1; i < min; i++) {
            if (numA % i == 0 && numB % i == 0) {
                int mcd = i;
                mcm = (numA * numB) / mcd;
            }
        }
        return mcm;
    }
    
    public int calcularMaximoComunDivisor(int numA, int numB){
        
        if (numB == 0){
            return numA;
        }
        return calcularMaximoComunDivisor(numB, numA % numB);
    }

    @Override
    public String toString() {
        return this.x + "/" + this.y;
    }
}
