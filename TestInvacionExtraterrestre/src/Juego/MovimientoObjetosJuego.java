package Juego;

import java.awt.Color;

/**
 * 
 * @author @LastShadow
 */
public abstract class MovimientoObjetosJuego extends ObjetosJuego implements Mover {

    int velocidadX;
    int velocidadY;

    /**
     * Constructor para cualquier objeto del juego que no sea controlado su
     * movimiento por teclado, y tenga un movimiento predefinido.
     * @param velocidadX
     * @param velocidadY
     * @param posicionX
     * @param posicionY
     * @param color 
     */
    public MovimientoObjetosJuego(int velocidadX, int velocidadY, int posicionX, int posicionY, Color color) {
        super(posicionX, posicionY, color);
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
    }

    //Métodos de acceso de la clase
    public int getVelocidadX() {
        return velocidadX;
    }

    public void setVelocidadX(int velocidadX) {
        this.velocidadX = velocidadX;
    }

    public int getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(int velocidadY) {
        this.velocidadY = velocidadY;
    }
    
    /**
     * Método para darle movimiento a objetos del juego.
     */
    @Override
    public void mover(){
        this.posicionX += velocidadX;
        this.posicionY += velocidadY;
    }
    
}
