package Juego;

import Controles.ControlesTeclado;
import java.awt.Color;

/**
 * 
 * @author @LastShadow
 */
public abstract class ControlObjetosJuego extends ObjetosJuego implements Mover{

    ControlesTeclado control;

    /**
     * Constructor para el control de objetos del juego.
     * @param control
     * @param posicionX
     * @param posicionY
     * @param color 
     */
    public ControlObjetosJuego(ControlesTeclado control, int posicionX, int posicionY, Color color) {
        super(posicionX, posicionY, color);
        this.control = control;
    }    
  
}
