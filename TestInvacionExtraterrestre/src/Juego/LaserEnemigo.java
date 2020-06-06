package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author @LastShadow
 */
public class LaserEnemigo extends MovimientoObjetosJuego {

    //Constructo del laser que disparan los enemigos
    public LaserEnemigo(int posicionX, int posicionY,int diametro,  Color color) {
        super(0, 0, posicionX, posicionY, color);
    }
    
    //Dibujaremos el laser
    @Override
    public void dibujar(Graphics g) {
        //Enviar el color del laser
        g.setColor(color);
        //Rellenamos el rectangulo indicando posicion y tamaño
        g.fillRect(posicionX, posicionY, 7, 15);
    }

    //Obtendremos si chocan los laser
    @Override
    public Rectangle getLimite() {
        Rectangle laserHitbox = new Rectangle(posicionX, posicionY, 7, 15);
        return laserHitbox;
    }

}
