package Reproductores;

import Interfaces.IMultimedia;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
class Grabadora implements IMultimedia{

    
    @Override
    public void reproducir() {
        System.out.println("Leyendo cinta magnética...");
        System.out.println("Reproduciendo....");
        System.out.println("Perfumes de gardenia");
    }
    
    @Override
    public void detener(){
        System.out.println("Detener la lectura de cinta magnética....");
    }
    
     @Override
    public void adelantar(){
        System.out.println("Adelantando pista...");
    }

    @Override
    public void retroceder() {
        System.out.println("Regresando pista...");
    }

    @Override
    public void siguiente() {
        System.out.println("Siguiente pista...");
    }    
    
    public void  grabar(){
        System.out.println("Grabando....");
    }
    
}
