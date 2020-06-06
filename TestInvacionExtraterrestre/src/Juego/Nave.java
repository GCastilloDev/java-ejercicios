package Juego;

import Controles.ControlesTeclado;
import Juego.ControlObjetosJuego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author @LastShadow
 */
public class Nave extends ControlObjetosJuego {

    ImageIcon nave = new ImageIcon("imagenes/shipSkin.gif");
    ImageIcon naveBonus = new ImageIcon("imagenes/bonusEnemySkin.gif");
    ImageIcon naveVidas = new ImageIcon("imagenes/shipSkinSmall.gif");

    /**
     * Constructor para todos los objetos de tipo Nave.
     *
     * @param control
     * @param posicionX
     * @param posicionY
     * @param color
     */
    public Nave(int posicionX, int posicionY, Color color, ControlesTeclado control) {
        super(control, posicionX, posicionY, color);
    }

    //Dibujar naveBonus
    public void dibujarNaveBonus(Graphics g) {
        naveBonus.paintIcon(null, g, this.getPosicionX(), this.getPosicionY());
    }
    
    

    //Dibujar naveVidas
    public void dibujarNaveVidas(Graphics g) {
        naveVidas.paintIcon(null, g, this.getPosicionX(), this.getPosicionY());
    }

    //Dibujar la nave que controlara el jugador.
    @Override
    public void dibujar(Graphics g) {
        nave.paintIcon(null, g, this.getPosicionX(), this.getPosicionY());
    }

    //Obtendremos el "HitBox" de todos los objetos Nave.
    @Override
    public Rectangle getLimite() {
        Rectangle naveHitbox = new Rectangle(this.getPosicionX(), this.getPosicionY(), 50, 50);
        return naveHitbox;
    }

    //Lo usaremos para mover la nave.
    @Override
    public void mover() {
        // Cuando presionamos la tecla izquierda
        if(control.getEstadoTeclado(37)){
            posicionX -= 10;
        }
        // Cuando presionamos la tecla derecha
        if(control.getEstadoTeclado(39)){
            posicionX += 10;
        }
        // Para moverse de lado a lado sin fin
        if(posicionX > 800){
            posicionX = -50;
        }
        if(posicionX < -50){
            posicionX = 800;
        }
    }

}
