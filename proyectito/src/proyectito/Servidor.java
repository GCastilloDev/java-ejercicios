/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectito;

/**
 *
 * @author @LastShadow
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        //puerto de nuestro servidor
        final int PUERTO = 5000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            //Espero a que un cliente se conecte
                sc = servidor.accept();

                System.out.println("Cliente conectado");
            while (true) {

                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                //Leo el mensaje que me envia
                String mensaje = in.readUTF();

                System.out.println(mensaje);

                //Le envio un mensaje
                if (mensaje.equalsIgnoreCase("hola")) {
                    out.writeUTF("hola desde el servidor");
                }
                if (mensaje.equalsIgnoreCase("salir")) {
                    out.writeUTF("Adios");
                    System.out.println("adios");
                    //Cierro el socket
                    sc.close();
                    System.out.println("Cliente desconectado");
                    break;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
