package Reproductores;

import Interfaces.IMultimedia;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class WindowsMediaPlayer implements IMultimedia {

    @Override
    public void detener() {
        System.out.println("Detener reproducción...");
    }

    public void clonarCD() {
        System.out.println("Copiando archivos de audio de CD a la PC");
    }

    @Override
    public void reproducir() {
        System.out.println("Cargando archivo en memoria...");
        System.out.println("Reproduciendo música...");
        System.out.println("Perfume de gardenia.wav");
    }

    @Override
    public void retroceder() {
        System.out.println("Reproducir archivo anterior....");
    }

    @Override
    public void adelantar() {
        System.out.println("Adelantando archivo....");
    }

    @Override
    public void siguiente() {
        System.out.println("Reproduciendo siguiente archivo....");
    }
}
