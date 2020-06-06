package Modelo.Datos;

import java.io.Serializable;

/**
 * 
 * @author LastShadow
 */
public class Contacto implements Serializable{
    private String numCelular;
    private String numFijo;
    private String facebook;
    private String twitter;
    private String correo;

    public Contacto(){}
    
    public Contacto(String numCelular, String numFijo, String facebook, String twitter, String correo) {
        this.numCelular = numCelular;
        this.numFijo = numFijo;
        this.facebook = facebook;
        this.twitter = twitter;
        this.correo = correo;
    }
    
    

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getNumFijo() {
        return numFijo;
    }

    public void setNumFijo(String numFijo) {
        this.numFijo = numFijo;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Contacto{" + "numCelular=" + numCelular + ", numFijo=" + numFijo + ", facebook=" + facebook + ", twitter=" + twitter + ", correo=" + correo + '}';
    }
}
