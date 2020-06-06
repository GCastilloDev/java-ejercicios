package Reproductores;

import Interfaces.IMultimedia;

/**
 *
 * @author Gustavo <@LastShadow>
 */
class Discman implements IMultimedia {

    @Override
    public void reproducir() {
        System.out.println("Mover la cabeza de lectura a través de un laser");
        System.out.println("Perfumes de gardenia.mp3");
    }

    @Override
    public void detener() {
        System.out.println("Detener lectura de la pista de CD");
        System.out.println("Mover cabeza lectora en posición inicial");
    }

    @Override
    public void retroceder() {
        System.out.println("Mover cabeza lectora hacía atras de la pista...");
    }

    @Override
    public void adelantar() {
        System.out.println(" Avanzando pista...");
    }

    @Override
    public void siguiente() {
        System.out.println("Reproducir la siguiente pista");
        System.out.println("Fue en un cabaret.mp3");
    }
}
