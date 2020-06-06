package Juego;
import java.awt.Color;
import java.awt.Rectangle;

/**
 * 
 * @author @LastShadow
 */
public abstract class ObjetosJuego implements Dibujar {

    int posicionX;
    int posicionY;
    Color color;
    boolean chocaste;

    //Constructor de la clase
    public ObjetosJuego() {
    }

    /**
     * Constructor con párametros de posición y color.
     * @param posicionX
     * @param posicionY
     * @param color 
     */
    public ObjetosJuego(int posicionX, int posicionY, Color color) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.color = color;
    }
    
    
    /**
     * Método abstracto que me va a permitir saber los limites de mis
     * imagenes u objetos.
     * @return 
     */
    public abstract Rectangle getLimite();

    /**
     * Método que me permite obtener la posición en "X" de cualquier objeto.
     * @return 
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * Método que me permite establecer la posición en "X" de cualquier objeto.
     * @param posicionX 
     */
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * Método que me permite obtener la posición en "Y" de cualquier objeto.
     * @return 
     */
    public int getPosicionY() {
        return posicionY;
    }

    /**
     * Método que me permite establecer la posición en "Y" de cualquier objeto.
     * @param posicionY
     */
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
    /**
     * Método que me permite obtener el color de cualquier objeto del juego.
     * @return 
     */
    public Color getColor() {
        return color;
    }

    /**
     * Método que me permite establecer y/o enviar el color de cualquier objeto del juego.
     * @param color 
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /*
    HitBox es una técnica para la detección de colisiones en tiempo real.
    */
    
    /**
     * Método que me permite saber si dos objetos han chocado.
     * Se pasa por párametro un objeto de la misma clase para saber
     * si han chocado a través del método de intersects.
     * @param otroObj
     * @return 
     */
    public boolean chocaste(ObjetosJuego otroObj){
        chocaste = otroObj.getLimite().intersects(this.getLimite());
        return chocaste;
    }
}