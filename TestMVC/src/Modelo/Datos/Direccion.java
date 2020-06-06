package Modelo.Datos;

import java.io.Serializable;

/**
 *
 * @author LastShadow
 */
public class Direccion implements Serializable{

    private String calle;
    private String colonia;
    private String ciudad;
    private String estado;
    private String cp;

    public Direccion(){}
    
    public Direccion(String calle, String colonia, String ciudad, String estado, String cp) {
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cp = cp;
    }
    
    

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", colonia=" + colonia + ", ciudad=" + ciudad + ", estado=" + estado + ", cp=" + cp + '}';
    }
}
