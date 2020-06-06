package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author @LastShadow
 */
public class ControlesTeclado implements KeyListener{
    
    private boolean[] estadoTeclado;

    public ControlesTeclado() {
        this.estadoTeclado = new boolean[256];
    }

    public boolean getEstadoTeclado(int codigoTeclado) {
        if (codigoTeclado < 0 || codigoTeclado > 255){
            return false;
        }else{
            return estadoTeclado[codigoTeclado];
        }
    }
    
    public void reiniciarControles(){
        estadoTeclado = new boolean[256];
    } 
        
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Paso el código de la tecla oprimida al estado del teclado
        //he indico con true que fue oprimida
        estadoTeclado[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
       //Paso el código de la tecla que libero
       //he indico al método que no se establezca en false
       estadoTeclado[e.getKeyCode()] = false;
    }

}
