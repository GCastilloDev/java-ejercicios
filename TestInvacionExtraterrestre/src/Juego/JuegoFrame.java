package Juego;

import javax.swing.JFrame;

/**
 *
 * @author @LastShadow
 */
public class JuegoFrame extends JFrame {

    private JuegoPanel juego;

    public JuegoFrame() {
        //Añadir texto a la barra de titulo
        super("Invación Extraterrestre USTV 401 TIC");
        //Salir cuando se aprieta el boton cerrar
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //Instancia el objeto juego y activa el buffer doble
        //para asegurar una animacion suave
        juego = new JuegoPanel();
        juego.setDoubleBuffered(true);

        //Agrega los elementos
        this.getContentPane().add(juego);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //Iniciar Juego
        juego.start();

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JuegoFrame().setVisible(true);
            }
        });
    }
}
