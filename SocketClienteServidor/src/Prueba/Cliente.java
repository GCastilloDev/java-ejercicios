/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * @author @LastShadow
 */
public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        Scanner n = null;

        try {
            kkSocket = new Socket("localhost", 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            n = new Scanner(System.in);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: manis.csi.ull.es.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: manis.csi.ull.es.");
            System.exit(1);
        }
        
        String fromServer;
        String fromUser;
        
        while(true){            
            
            fromServer = in.readLine();
            System.out.println("Respuesta del servidor: " + fromServer);
                        
            System.out.println("Escribe un mensaje:");
            fromUser = n.nextLine();
            out.println(fromUser);
            
            if(fromUser.equalsIgnoreCase("bye")){
                break;
            }           
            
        }
        
        out.close();
        in.close();
        kkSocket.close();
    }

}
