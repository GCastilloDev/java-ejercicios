/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author @LastShadow
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);

        try {
            /*
            1.- El ciente se coneta al servidor: localhost(ip, url) usando el
            número de puerto 1026 el cual fue establecido por el servidor.
             */
            Socket cliente = new Socket("localhost", 1025);

            /*
            2.- Leer el mensaje enviado por el servidor
             */
            DataInputStream lectura = new DataInputStream(cliente.getInputStream());
            String mensajeDelServidor = lectura.readUTF();
            System.out.println("Respuesta del servidor: " + mensajeDelServidor);
            System.out.println(cliente);

            while (true) {
                cliente = new Socket("localhost", 1025);
                DataOutputStream msgSalida = new DataOutputStream(cliente.getOutputStream());
                System.out.println("Ingresa comando");
                String mensajeSalida = n.nextLine();
                msgSalida.writeUTF(mensajeSalida);

                if (mensajeSalida.equalsIgnoreCase("salir")) {
                    cliente.close();
                    lectura.close();
                    msgSalida.close();
                }else{
                mensajeDelServidor = lectura.readUTF();
                System.out.println("Respuesta 1 " + mensajeDelServidor);
                }
            }

            //3.- El cliente saluda al servidor
//            cliente = new Socket("localhost", 1025);
//            System.out.println(cliente);
//            DataOutputStream msgSalida = new DataOutputStream(cliente.getOutputStream());
//            System.out.println("Ingresa comando");
//            String mensajeSalida = n.nextLine();
//            msgSalida.writeUTF("Hola servidor, tu si me aceptas </3 pero ella no :'(");
//            msgSalida.writeUTF(mensajeSalida);
//            mensajeDelServidor = lectura.readUTF();
//            System.out.println("Respuesta 1 " + mensajeDelServidor);
            /*
            4.- Cerramos todos los servicios
             */
//            cliente.close();
//            lectura.close();
//            msgSalida.close();
        } catch (IOException ex) {
            System.out.println("Error 1. " + ex.getMessage());
        }
    }

}
