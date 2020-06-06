package Ejercicio003;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Coche implements Comparable<Coche>{

    private String matricula;
    private String marca;
    private String modelo;
    private Integer Km;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public int getKm() {
        return Km;
    }

    public void setKm(int Km) {
        this.Km = Km;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", Km=" + Km + '}';
    }

    @Override
    public int compareTo(Coche o) {
        return Km.compareTo(o.getKm());
    }
    
    
}
