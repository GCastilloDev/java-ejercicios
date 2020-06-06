package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author @LastShadow
 */
public class Escudos extends ObjetosJuego{
    
    int ancho;
    int alto;
    
    //Constructor de la clase
    public Escudos(int posicionX, int posicionY, int ancho, int alto, Color color){
        super(posicionX, posicionY, color);
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    
    
    @Override
    public Rectangle getLimite() {
        Rectangle escudosHitbox = new Rectangle(this.getPosicionX(), this.getPosicionY(), 90, 10);
        return escudosHitbox;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(this.getPosicionX(), this.getPosicionY(), 90, 10);
    }

}
