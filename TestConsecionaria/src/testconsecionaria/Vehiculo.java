package testconsecionaria;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Vehiculo {

    private int codigo;
    private String marca;
    private String tipo;
    private int modelo;
    private String patente;
    private int kilometraje;

    public Vehiculo(int codigo, String marca, String tipo, int modelo, String patente, int kilometraje) {
        this.codigo = codigo;
        this.marca = marca;
        this.tipo = tipo;
        this.modelo = modelo;
        this.patente = patente;
        this.kilometraje = kilometraje;
    }

    public Vehiculo() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

}
