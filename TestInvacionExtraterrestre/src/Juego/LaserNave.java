package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author @LastShadow
 */
public class LaserNave extends MovimientoObjetosJuego{
    
    //Diametro del laser
    int diametro;


    public LaserNave(int posicionX, int posicionY, int diametro, Color color){
        super(0, 0, posicionX, posicionY, color);
        this.diametro = diametro;
    }

    public int getDiametro() {
        return diametro;
    }
    
    //Obtiene el hitbox del laser
    @Override
    public Rectangle getLimite() {
        Rectangle laserNaveHitbox = new Rectangle(posicionX, posicionY, 7, 15);
        return laserNaveHitbox;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(posicionX, posicionY, 7, 15);
    }

}
