/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author @LastShadow
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int numeroDePuerto = 1025;

            //La siguiente línea inicia el servicio con el número de puerto especificado:
            ServerSocket servidor = new ServerSocket(numeroDePuerto);

            //Crear un objeto de tipo socket para la comunicación entre el cliente/servidor:
            Socket socket;

            //En la siguiente línea el servidor acepta la conexión de un cliente,
            //el resultado es un objeto de tipo socket.  
            System.out.println("Esperando la conexión del cliente...");
            socket = servidor.accept();
            System.out.println("Cliente conectado.");

            DataOutputStream flujoDeSalida = new DataOutputStream(socket.getOutputStream());
            DataInputStream msgEntrada;
            flujoDeSalida.writeUTF("Hola cliente, bienvenido");

            while (true) {
                socket = servidor.accept();

                msgEntrada = new DataInputStream(socket.getInputStream());
                String msgCliente = msgEntrada.readUTF();
                

                if (msgCliente.equalsIgnoreCase("HOLA")) {
                    System.out.println("prueba saludando");
                    flujoDeSalida.writeUTF("prueba saludando");
                }
                if (msgCliente.equalsIgnoreCase("salir")) {
                    flujoDeSalida.writeUTF("Adios cliente");
                    servidor.close();
                    socket.close();
                    flujoDeSalida.close();
                    msgEntrada.close();
                    break;
                }

                flujoDeSalida = new DataOutputStream(socket.getOutputStream());

            }

            //Crear un flujo de I/O
//            DataOutputStream flujoDeSalida = new DataOutputStream(socket.getOutputStream());
//            flujoDeSalida.writeUTF("Hola cliente, bienvenido");
//            
//            
//            //El servidor lee lo que el cliente le responde
//            socket = servidor.accept();
//            DataInputStream msgEntrada = new DataInputStream(socket.getInputStream());
//            String msgCliente = msgEntrada.readUTF();
//            
//            if(msgCliente.equalsIgnoreCase("HOLA")){
//                System.out.println("prueba saludando");
//                flujoDeSalida.writeUTF("prueba saludando");
//            }else{
//                System.out.println("prueba error");
//                flujoDeSalida.writeUTF("prueba error");
//            }
//            System.out.println("Respuesta del cliente: " + msgCliente);
            //Cerrar todo
//            servidor.close();
//            socket.close();
//            flujoDeSalida.close();
//            msgEntrada.close();
        } catch (IOException ex) {
            System.out.println("No se puede iniciar el servicio. Error " + ex.getMessage());
        }
    }

}
