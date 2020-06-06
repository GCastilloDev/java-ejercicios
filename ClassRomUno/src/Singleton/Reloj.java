/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Reloj extends Thread {
    
    private static Reloj instancia;
    
    private Reloj(){
        
    }

    @Override
    public void run() {

        while (true) {
            Date fecha = new Date();
            DateFormat Formato = new SimpleDateFormat("HH:mm:ss");
           
              System.out.println("Hora: " + Formato.format(fecha));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }
    }

    public static Reloj getReloj(){
        if(instancia == null){
            return instancia = new Reloj();
        }
        else{
            return instancia;
        }
    }
    
    
}
