package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author @LastShadow
 */
public class Enemigos extends MovimientoObjetosJuego {

    ImageIcon alien1 = new ImageIcon("imagenes/alien1Skin.gif");
    ImageIcon alien2 = new ImageIcon("imagenes/alien2Skin.gif");
    ImageIcon alien3 = new ImageIcon("imagenes/alien3Skin.gif");
    ImageIcon jefeAlien1 = new ImageIcon("imagenes/boss1.gif");
    ImageIcon jefeAlien2 = new ImageIcon("imagenes/boss2.gif");
    ImageIcon jefeAlien3 = new ImageIcon("imagenes/boss3.gif");

    private int tipoEnemigo;
    private int ancho;
    private int alto;

    //Constructor de la clase
    public Enemigos(int posicionX, int posicionY, int velocidadX, int velocidadY, int tipoEnemigo, Color color, int ancho, int alto) {
        super(velocidadX, velocidadY, posicionX, posicionY, color);
        this.tipoEnemigo = tipoEnemigo;
        this.ancho = ancho;
        this.alto = alto;
    }

    //Dibujaremos a los aliens
    @Override
    public void dibujar(Graphics g) {
        //Variante aliens 1,2 y 3
        if(this.tipoEnemigo % 3 == 0){
            alien1.paintIcon(null, g, this.posicionX, this.posicionY);
        }else if (this.tipoEnemigo % 3 == 1){
            alien2.paintIcon(null, g, this.posicionX, this.posicionY);
        }else if (this.tipoEnemigo % 3 == 2){
            alien3.paintIcon(null, g, this.posicionX, this.posicionY);
        }
        
        //Colores del jefe alien
        if(this.tipoEnemigo == 100){
            if(JuegoPanel.getVidaJefeAlien() > 20){
                jefeAlien1.paintIcon(null, g, this.posicionX, this.posicionY);
            }else if (JuegoPanel.getVidaJefeAlien() > 10){
                jefeAlien2.paintIcon(null, g, this.posicionX, this.posicionY);
            }else if (JuegoPanel.getVidaJefeAlien() > 0){
                jefeAlien3.paintIcon(null, g, this.posicionX, this.posicionY);
            }
        }
        
    }

    //Obtener el hitbox de los enemigos
    @Override
    public Rectangle getLimite() {
        Rectangle enemigosHitbox = new Rectangle(this.posicionX, this.posicionY, ancho, alto);
        return enemigosHitbox;
    }
    
    @Override
    public void mover(){
        posicionX += velocidadX;
    }

}
