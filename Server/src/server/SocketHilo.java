/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.net.Socket;

/**
 * 
 * @author @LastShadow
 */
public class SocketHilo extends Thread{
    
    private Socket cliente;

    public SocketHilo(Socket cliente){
        this.cliente = cliente;
    }
    
    @Override
    public void run(){
        //Flujos de comunicacion I/O
    }
}
