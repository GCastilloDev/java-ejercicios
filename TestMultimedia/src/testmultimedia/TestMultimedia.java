package testmultimedia;

import Reproductores.FabricaMultimedia;
import Interfaces.IMultimedia;
import Reproductores.WindowsMediaPlayer;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class TestMultimedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IMultimedia objeto = FabricaMultimedia.getTipoReproductor("discman");
        System.out.println("DISCMAN SONY");
        objeto.reproducir();
        objeto.adelantar();
        objeto.detener();
        objeto.retroceder();
        objeto.siguiente();
        System.out.println("");

        System.out.println("GRABADORA");
        objeto = FabricaMultimedia.getTipoReproductor("grabadora");
        objeto.reproducir();
        objeto.adelantar();
        objeto.detener();
        objeto.retroceder();
        objeto.siguiente();
        System.out.println("");

        System.out.println("WINDOWS MEDIA PLAYER");
        objeto = FabricaMultimedia.getTipoReproductor("mediaplayer");
        if (objeto instanceof WindowsMediaPlayer) {
            WindowsMediaPlayer obj = (WindowsMediaPlayer) objeto;
            obj.reproducir();
            obj.adelantar();
            obj.detener();
            obj.retroceder();
            obj.siguiente();
            obj.clonarCD();
        }
        
    }
}


