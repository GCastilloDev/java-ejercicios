/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testhilos;

/**
 * 
 * @author @LastShadow
 */
public class Documento extends Thread{
    
    String texto;
    
    public Documento(String texto){
        this.texto = texto;
    }
    
    @Override
    public void run(){
        System.out.println("Procesando el documento....");
        for (int i = 0; i < 10; i++) {
            System.out.println(this.texto + " - " + (i+1) + " procesado.");
        }

//        int i = 1;
//        while(true){
//            System.out.println(this.texto + " - " + (i+1) + " procesado.");
//            i++;
//        }
    }

}
