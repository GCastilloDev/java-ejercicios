package Unidad1.TestHerencia;

/**
 *
 * @author gustavo
 */
public class Automovil {
    
    //Atributos
    private String marca;
    private String modelo;
    private String color;
    private String numSerie;
    private int potencia;
    
    //Métodos de acceso
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }        
    
}
