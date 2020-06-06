/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Controles.ControlesTeclado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author @LastShadow
 */
public class JuegoPanel extends JPanel {

    private Timer tiempoJuego;
    private ControlesTeclado control;
    private String nombreJugador;
    //Tamaño y cuadros por segundo del juego
    private final int anchoJuego = 800;
    private final int altoJuego = 600;
    private final int framesPorSegundo = 120;

    //Contadores
    Random r = new Random();
    private int puntuacion = 0;
    private int nivel = 1;
    private int numeroDeVidas = 3;
    private int puntuacionMaxima;
    private int marcadorX;
    private int marcadorY;
    private static int vidaJefeAlien = 30;
    File f = new File("puntuacionMaxima.txt");

    //Añadimos los objetos del juego
    private Nave naveJugador;
    private Nave naveVida;
    private Nave naveBonus;
    private Enemigos enemigo;
    private Escudos escudo;
    private LaserNave laserNave;
    private LaserEnemigo laserEnemigo1;
    private LaserEnemigo laserEnemigo2;
    private LaserEnemigo laserEnemigo3;

    //Booleanos
    private boolean laserNavePuedeDisparar = true;
    private boolean laserEnemigoPuedeDisparar = true;
    private boolean hayNaveBonus = true;
    private boolean dioEnObjetivo = false;

    //Crear Array Lists
    private ArrayList<Nave> vidaLista = new ArrayList();
    private ArrayList<Nave> naveBonusLista = new ArrayList();
    private ArrayList<Enemigos> enemigosLista = new ArrayList();
    private ArrayList<Escudos> escudosLista = new ArrayList();
    private ArrayList<LaserEnemigo> laserEnemigoLista = new ArrayList();

    //Imagen de fondo
    private ImageIcon fondo = new ImageIcon("imagenes/backgroundSkin.jpg");

    //Sonidos
    private File beamSound = new File("sounds/alienBeam.wav");
    private File bulletSound = new File("sounds/bulletSound.wav");
    private File levelUpSound = new File("sounds/levelUpSound.wav");
    private File deathSound = new File("sounds/deathSound.wav");
    private File hitmarkerSound = new File("sounds/hitmarkerSound.wav");
    private File shieldSound = new File("sounds/shieldSound.wav");
    private File bossSound = new File("sounds/bossSound.wav");
    private File bonusSound = new File("sounds/bonusSound.wav");
    private File damageSound = new File("sounds/damageSound.wav");
    private AudioStream beamSoundAudio;
    private InputStream beamSoundInput;
    private AudioStream bulletSoundAudio;
    private InputStream bulletSoundInput;
    private AudioStream levelUpSoundAudio;
    private InputStream levelUpSoundInput;
    private AudioStream deathSoundAudio;
    private InputStream deathSoundInput;
    private AudioStream hitSoundAudio;
    private InputStream hitSoundInput;
    private AudioStream shieldSoundAudio;
    private InputStream shieldSoundInput;
    private AudioStream bossSoundAudio;
    private InputStream bossSoundInput;
    private AudioStream bonusSoundAudio;
    private InputStream bonusSoundInput;
    private AudioStream damageSoundAudio;
    private InputStream damageSoundInput;

    public static int getVidaJefeAlien() {
        return vidaJefeAlien;
    }

///////////////////////////////////////////////////////////////////////////    
    //Configuración del juego
    public final void configuracionJuego() {

        //Crear los aliens de los niveles normales
        if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
            //Seis filas
            for (int filas = 0; filas < 6; filas++) {
                //Cinco columnas
                for (int columnas = 0; columnas < 5; columnas++) {
                    enemigo = new Enemigos((20 + (filas * 100)), (20 + (columnas * 60)), nivel, 0, columnas, null, 40, 40);
                    enemigosLista.add(enemigo);
                }
            }
        }

        //Crear aliens jefes para sus niveles
        if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
            AudioPlayer.player.start(bossSoundAudio);//Rugido alien jefe
            enemigo = new Enemigos(20, 20, 3, 0, 100, null, 150, 150);
            enemigosLista.add(enemigo);
        }

        //Mensaje de Bienvenida y obtner nombre del jugador
        if (nivel == 1) {
            String mensaje = "Bienvenido al juego!!"
                    + "\nPresiona la barra espaciadora para disparar"
                    + "\nMuevete con las teclas izquierda y derecha"
                    + "\n¿Cuál es tu nombre?";
            String titulo = "Invación Extraterrestre - UTSV 401 TIC";
            nombreJugador = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
        }

        //Reinicia los controles del teclado
        control.reiniciarControles();

        //Valores iniciales nave del jugador
        naveJugador = new Nave(375, 530, null, control);

        //Valores iniciales de las nave de vidas
        for (int columna = 0; columna < numeroDeVidas; columna++) {
            naveVida = new Nave(48 + (columna * 20), 10, null, null);
            vidaLista.add(naveVida);
        }

        //Valores para los escudos
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                escudo = new Escudos(100 + (columna * 250), 450 - (fila * 10), 70, 10, Color.RED);
                escudosLista.add(escudo);
            }

        }
    }

/////////////////////////////////////////////////////////////////////////
    //Dibujar
    @Override
    public void paint(Graphics g) {

        //Imagen de fondo
        fondo.paintIcon(null, g, 0, -250);

        //Crea los mensajes de puntuación cuando le pegas a un enemigo
        if (laserNave != null) {
            if (dioEnObjetivo) {
                g.setColor(Color.WHITE);
                if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
                    g.drawString("+100", marcadorX + 20, marcadorY -= 1);
                } else {
                    g.drawString("-1", marcadorX + 75, marcadorY += 1);
                }
            }
        }

        //Dibujar nave del jugador
        naveJugador.dibujar(g);

        //Dibuja los tres escudos espaciados uniformemente
        for (int i = 0; i < escudosLista.size(); i++) {
            escudosLista.get(i).dibujar(g);
        }

        //Dibuja a los tres diferentes aliens
        try{
        for (int i = 0; i < enemigosLista.size(); i++) {
            enemigosLista.get(i).dibujar(g);
        }
        }catch(IndexOutOfBoundsException e){
                
                }

        //Dibuja el laser cuando se oprime la barra espaciadora
        if (control.getEstadoTeclado(32)) {
            if (laserNavePuedeDisparar) {
                laserNave = new LaserNave(naveJugador.getPosicionX() + 22, naveJugador.getPosicionY() - 20, 0, Color.RED);
                AudioPlayer.player.start(bulletSoundAudio);
                laserNavePuedeDisparar = false;
            }
        }

        //Solo se sacara una bala despues de pulsar la tecla
        if (laserNave != null) {
            laserNave.dibujar(g);
        }

        //Generar disparos aleatorios de los aliens
        if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
            if (laserEnemigoPuedeDisparar) {
                for (int i = 0; i < enemigosLista.size(); i++) {
                    if (r.nextInt(30) == i) {
                        laserEnemigo1 = new LaserEnemigo(enemigosLista.get(i).getPosicionX(), enemigosLista.get(i).getPosicionY(), 0, Color.YELLOW);
                        laserEnemigoLista.add(laserEnemigo1);
                        AudioPlayer.player.start(beamSoundAudio);
                    }
                    laserEnemigoPuedeDisparar = false;
                }
            }
        }

        //Generar disparos aleatorios de los aliens jefes
        if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
            if (laserEnemigoPuedeDisparar) {
                for (int i = 0; i < enemigosLista.size(); i++) {
                    if (r.nextInt(5) == i) {
                        laserEnemigo1 = new LaserEnemigo(enemigosLista.get(i).getPosicionX() + 75, enemigosLista.get(i).getPosicionY() + 140, 0, Color.YELLOW);
                        laserEnemigo2 = new LaserEnemigo(enemigosLista.get(i).getPosicionX(), enemigosLista.get(i).getPosicionY() + 110, 0, Color.YELLOW);
                        laserEnemigo3 = new LaserEnemigo(enemigosLista.get(i).getPosicionX() + 150, enemigosLista.get(i).getPosicionY() + 110, 0, Color.YELLOW);
                        laserEnemigoLista.add(laserEnemigo1);
                        laserEnemigoLista.add(laserEnemigo2);
                        laserEnemigoLista.add(laserEnemigo3);
                        AudioPlayer.player.start(beamSoundAudio);
                    }
                    laserEnemigoPuedeDisparar = false;
                }
            }
        }

        //Dibujar disparos generados
        for (int i = 0; i < laserEnemigoLista.size(); i++) {
            laserEnemigoLista.get(i).dibujar(g);
        }

        //Generar naveBonus
        if (hayNaveBonus) {
            if (r.nextInt(3000) == 1500) {
                naveBonus = new Nave(-50, 30, Color.RED, null);
                naveBonusLista.add(naveBonus);
                hayNaveBonus = false;
            }
        }

        //Dibujar naveBonus
        for (int i = 0; i < naveBonusLista.size(); i++) {
            naveBonusLista.get(i).dibujar(g);
        }

        //Establece el mensaje de puntuacion
        g.setColor(Color.WHITE);
        g.drawString("Puntuación " + nombreJugador + ":" + puntuacion, 260, 20);

        //Establece el contador de vidas
        g.setColor(Color.WHITE);
        g.drawString("Vidas:", 11, 20);
        for (int i = 0; i < vidaLista.size(); i++) {
            vidaLista.get(i).dibujarNaveVidas(g);
        }

        //Establecer mensaje de nivel
        g.setColor(Color.WHITE);
        g.drawString("Nivel: " + nivel, 750, 20);

        //Establecer mensaje puntuacion maxima
        g.setColor(Color.WHITE);
        g.drawString("Puntuación máxima: " + puntuacionMaxima, 440, 20);

        //Dibujar vida del jefe alien
        if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
            g.setColor(Color.WHITE);
            g.drawString("Vida del jefe: " + vidaJefeAlien, 352, 590);
        }
    }

////////////////////////////////////////////////////////////////
    //Actualizar estado del juego
    public void actualizarEstadoDelJuego(int frameNumber) {

        //Permite que el jugador se mueva a la izquierda o derecha
        naveJugador.mover();

        //Cargar puntuación máxima
        try {
            Scanner fileScan = new Scanner(f);
            while (fileScan.hasNextInt()) {
                String lineaTexto = fileScan.nextLine();
                Scanner lineScan = new Scanner(lineaTexto);
                puntuacionMaxima = lineScan.nextInt();
            }
        } catch (FileNotFoundException e) {

        }

        //Actualiza el archivo si la puntuacion actual es mas alta que la anterior
        try {
            if (puntuacion > puntuacionMaxima) {
                String puntuacionString = Integer.toString(puntuacion);
                PrintWriter pw = new PrintWriter(new FileOutputStream(f, false));
                pw.write(puntuacionString);
                pw.close();
            }
        } catch (FileNotFoundException e) {

        }

        //Mover aliens y que cambien de direccion en los bordes
        if ((enemigosLista.get(enemigosLista.size() - 1).getPosicionX() + enemigosLista.get(enemigosLista.size() - 1).getVelocidadX()) > 760 || (enemigosLista.get(0).getPosicionX() + enemigosLista.get(0).getVelocidadX()) < 0) {
            for (int index = 0; index < enemigosLista.size(); index++) {
                enemigosLista.get(index).setVelocidadX(enemigosLista.get(index).getVelocidadX() * -1);
                enemigosLista.get(index).setPosicionY(enemigosLista.get(index).getPosicionY() + 10);
            }
        } else {
            for (int index = 0; index < enemigosLista.size(); index++) {
                enemigosLista.get(index).mover();
            }
        }

        //Mover laserNave
        if (laserNave != null) {
            laserNave.setPosicionY(laserNave.getPosicionY() - 15);
            if (laserNave.getPosicionY() < 0) {
                laserNavePuedeDisparar = true;
            }
            //Comprobar colisiones con aliens
            for (int index = 0; index < enemigosLista.size(); index++) {
                if (laserNave.chocaste(enemigosLista.get(index))) {
                    AudioPlayer.player.start(hitSoundAudio); // Plays hitmarker sound if you hit an enemy
                    laserNave = new LaserNave(0, 0, 0, null);
                    laserNavePuedeDisparar = true;
                    // Actulizacion de puntuacion
                    if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
                        puntuacion += 100;
                        dioEnObjetivo = true;
                        marcadorX = enemigosLista.get(index).getPosicionX(); // obtiene la posicion que generan los "+ 100" 
                        marcadorY = enemigosLista.get(index).getPosicionY();
                        enemigosLista.remove(index);

                    }
                    // Actualiza posicion de aliens jefes
                    if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
                        dioEnObjetivo = true;
                        marcadorX = enemigosLista.get(index).getPosicionX(); // obtiene la posicion que generan los "- 1" 
                        marcadorY = enemigosLista.get(index).getPosicionY() + 165;
                        vidaJefeAlien -= 1;
                        if (vidaJefeAlien == 0) {
                            enemigosLista.remove(index);
                            puntuacion += 9000;// Puntuacion por derrotar al jefe alien
                        }
                    }
                }
            }
            // Verifica si colisionaron con escudos y balas
            for (int index = 0; index < enemigosLista.size(); index++) {
                System.out.println("index " + index);
                System.out.println("tamaño " + enemigosLista.size());
                System.out.println("tamaño escudo lista " + escudosLista.size());
                if (laserNave.chocaste(escudosLista.get(index))) {
                    // Cada if cambia el color del escudo indicando fuerza
                    // ALTO
                    if (escudosLista.get(index).getColor() == Color.RED) {
                        escudosLista.get(index).setColor(Color.ORANGE);
                        //AudioPlayer.player.start(shieldSoundAudio); // Plays sound if shield takes damage
                        laserNave = new LaserNave(0, 0, 0, null);
                        laserNavePuedeDisparar = true;
                        // MEDIO
                    } else if (escudosLista.get(index).getColor() == Color.ORANGE) {
                        escudosLista.get(index).setColor(Color.YELLOW);
                        //AudioPlayer.player.start(shieldSoundAudio);
                        laserNave = new LaserNave(0, 0, 0, null);
                        laserNavePuedeDisparar = true;
                        // BAJO
                    } else if (escudosLista.get(index).getColor() == Color.YELLOW) {
                        escudosLista.get(index).setColor(Color.WHITE);
                        //AudioPlayer.player.start(shieldSoundAudio);
                        laserNave = new LaserNave(0, 0, 0, null);
                        laserNavePuedeDisparar = true;
                        // MUY BAJO
                    } else if (enemigosLista.get(index).getColor() == Color.WHITE) {
                        enemigosLista.remove(index);
                        //AudioPlayer.player.start(shieldSoundAudio);
                        laserNave = new LaserNave(0, 0, 0, null);
                        laserNavePuedeDisparar = true;
                    }
                }
            }

        }//cierre if

        // Mover naveBonus
        if (!naveBonusLista.isEmpty()) {
            for (int index = 0; index < naveBonusLista.size(); index++) {
                naveBonusLista.get(index).setPosicionX(naveBonusLista.get(index).getPosicionX() + (2));
                if (naveBonusLista.get(index).getPosicionX() > 800) {
                    naveBonusLista.remove(index);
                    hayNaveBonus = true;
                }
            }

            // naveBonus y laser chocaron?
            for (int index = 0; index < naveBonusLista.size(); index++) {
                if (laserNave != null) {
                    if (naveBonusLista.get(index).chocaste(laserNave)) {
                        naveBonusLista.remove(index);
                        laserNave = new LaserNave(0, 0, 0, null);
                        laserNavePuedeDisparar = true;
                        hayNaveBonus = true;
                        //AudioPlayer.player.start(bonusSoundAudio); // Plays sound if player hits a bonus enemy
                        puntuacion += 5000; // bonificacion
                    }
                }
            }
        }

        // Dar movimiento a los disparos de los aliens
        if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
            if (laserEnemigo1 != null) {
                for (int index = 0; index < laserEnemigoLista.size(); index++) {
                    laserEnemigoLista.get(index).setPosicionY(laserEnemigoLista.get(index).getPosicionY() + (4));
                    if (laserEnemigoLista.get(index).getPosicionY() > 600) {
                        laserEnemigoLista.remove(index);
                    }
                }
            }
        }

        // Dar movimiento de los disparos de los jefes aliens
        if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
            if (laserEnemigo1 != null) {
                for (int index = 0; index < laserEnemigoLista.size(); index++) {
                    laserEnemigoLista.get(index).setPosicionY(laserEnemigoLista.get(index).getPosicionY() + (2 * nivel)); //La velocidad de los disparos aumenta en cada nivel
                    if (enemigosLista.get(index).getPosicionY() > 600) {
                        enemigosLista.remove(index);
                    }
                }
            }
        }

        // Verificar si los disparos de los aliens choca con los escudos
        for (int j = 0; j < escudosLista.size(); j++) {
            for (int index = 0; index < laserEnemigoLista.size(); index++) {
                if (laserEnemigoLista.get(index).chocaste(escudosLista.get(j))) {

                    if (escudosLista.get(j).getColor() == Color.RED) {
                        escudosLista.get(j).setColor(Color.ORANGE);
                        //AudioPlayer.player.start(shieldSoundAudio); // Plays sound if shield takes damage
                        laserEnemigoLista.remove(index);

                    } else if (escudosLista.get(j).getColor() == Color.ORANGE) {
                        escudosLista.get(j).setColor(Color.YELLOW);
                        //AudioPlayer.player.start(shieldSoundAudio);
                        laserEnemigoLista.remove(index);

                    } else if (escudosLista.get(j).getColor() == Color.YELLOW) {
                        escudosLista.get(j).setColor(Color.WHITE);
                        //AudioPlayer.player.start(shieldSoundAudio);
                        laserEnemigoLista.remove(index);

                    } else if (escudosLista.get(j).getColor() == Color.WHITE) {
                        escudosLista.remove(j);
                        //AudioPlayer.player.start(shieldSoundAudio);
                        laserEnemigoLista.remove(index);
                    }
                }
            }
        }

        // Verificar si los disparos de los aliens chocan con la nave del jugador
        for (int i = 0; i < laserEnemigoLista.size(); i++) {
            if (laserEnemigoLista.get(i).chocaste(naveJugador)) {
                laserEnemigoLista.remove(i);
                //AudioPlayer.player.start(damageSoundAudio); // Plays damage sound
                vidaLista.remove(vidaLista.size() - 1); // Quita una vida si es golpeado por el laser
            }
        }

        //Permitir que los enemigos solo disparen rayos nuevos una vez que todos los rayos viejos salieron de la pantalla
        if (laserEnemigoLista.isEmpty()) {
            laserEnemigoPuedeDisparar = true;
        }

        //Destruye los escudos si los aliens chocan con ellos
        for (int input = 0; input < enemigosLista.size(); input++) {
            for (int j = 0; j < escudosLista.size(); j++) {
                if (enemigosLista.get(input).chocaste(escudosLista.get(j))) {
                    escudosLista.remove(j);
                }
            }
            // Si los aliens pasan la posicion de X asiganada se acaba el juego
            if (enemigosLista.get(input).getPosicionY() + 50 >= 550) {
                int pregunta = JOptionPane.showConfirmDialog(null, "Has perdido", "¿Deseas volver a jugar?", 0);
                if (pregunta == 0) {
                    vidaLista.clear();
                    enemigosLista.clear();
                    escudosLista.clear();
                    laserEnemigoLista.clear();
                    naveBonusLista.clear();
                    puntuacion = 0;
                    nivel = 1;
                    vidaJefeAlien = 30;
                    numeroDeVidas = 3;
                    laserEnemigoPuedeDisparar = true;
                    laserNavePuedeDisparar = true;
                    hayNaveBonus = true;
                    configuracionJuego();
                }
                if (pregunta == 1) {
                    System.exit(0);
                }
            }
        }

        //Actualizar el contador de vidas
        if (naveJugador.chocaste) {
            int index = vidaLista.size() - 1;
            vidaLista.remove(index);
        } //Termina el juego cuando el jugador se queda sin vidas
        else if (vidaLista.isEmpty()) {
            //AudioPlayer.player.start(deathSoundAudio); // Plays death sound when you run out of lives
           
            int pregunta = JOptionPane.showConfirmDialog(null, "Has perdido", "¿Deseas volver a jugar?", 0);
            if (pregunta == 0) {
                vidaLista.clear();
                enemigosLista.clear();
                escudosLista.clear();
                laserEnemigoLista.clear();
                naveBonusLista.clear();
                puntuacion = 0;
                nivel = 1;
                vidaJefeAlien = 30;
                numeroDeVidas = 3;
                laserEnemigoPuedeDisparar = true;
                laserNavePuedeDisparar = true;
                hayNaveBonus = true;
                configuracionJuego();
            }
            if (pregunta == 1) {
                System.exit(0);
            }
        }
        
        //Avanza al siguiente nivel y reestablece las listas y configura todos los contadores
        if (enemigosLista.isEmpty()) {
            laserEnemigoLista.clear();
            escudosLista.clear();
            naveBonusLista.clear();
            vidaLista.clear();
            nivel += 1;
            vidaJefeAlien = 30;
            configuracionJuego();
            //AudioPlayer.player.start(levelUpSoundAudio); // Plays level up sound
        }
        
        // Buffers de sonidos
        try {
            beamSoundInput = new FileInputStream(beamSound);
            //beamSoundAudio = new AudioStream(beamSoundInput);
            bulletSoundInput = new FileInputStream(bulletSound);
            //bulletSoundAudio = new AudioStream(bulletSoundInput);
            levelUpSoundInput = new FileInputStream(levelUpSound);
            //levelUpSoundAudio = new AudioStream(levelUpSoundInput);
            deathSoundInput = new FileInputStream(deathSound);
            //deathSoundAudio = new AudioStream(deathSoundInput);
            hitSoundInput = new FileInputStream(hitmarkerSound);
            //hitSoundAudio = new AudioStream(hitSoundInput);
            shieldSoundInput = new FileInputStream(shieldSound);
            //shieldSoundAudio = new AudioStream(shieldSoundInput);
            bossSoundInput = new FileInputStream(bossSound);
            //bossSoundAudio = new AudioStream(bossSoundInput);
            bonusSoundInput = new FileInputStream(bonusSound);
            //bonusSoundAudio = new AudioStream(bonusSoundInput);
            damageSoundInput = new FileInputStream(damageSound);
            //damageSoundAudio = new AudioStream(damageSoundInput);
        } catch (IOException e) {
        }

    }
    
////////////////////////////////////////////////////////////////////////////
    //Panel del Juego (constructor)
    public JuegoPanel(){
        // Establecer el panel
        this.setSize(anchoJuego, altoJuego);
        this.setPreferredSize(new Dimension(anchoJuego, altoJuego));
        this.setBackground(Color.BLACK);
        
        // Registrar el control de teclado como KeyListener
        control = new ControlesTeclado();
        this.addKeyListener(control);
        
        // Llama a configuracionJuego para inicializar todo
        this.configuracionJuego();
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    public void start() {
        
        tiempoJuego = new Timer(1000 / framesPorSegundo, new ActionListener() {

           
            private int frameNumber = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualiza el estado el juego y vuelve a pintar la pantalla
                actualizarEstadoDelJuego(frameNumber++);
                repaint();
            }
        });
        Timer gameTimerHitMarker = new Timer(1000, new ActionListener() {

           
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dioEnObjetivo = false;
            }
        });

        tiempoJuego.setRepeats(true);
        tiempoJuego.start();
        gameTimerHitMarker.setRepeats(true);
        gameTimerHitMarker.start();
    }

}
