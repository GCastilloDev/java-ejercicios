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
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        //Host del servidor
        final String HOST = "localhost";
        //Puerto del servidor
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        Scanner n = new Scanner(System.in);
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            

            while(true){
                System.out.print("> ");
                String comando = n.nextLine();
                //Envio un mensaje al cliente
                out.writeUTF(comando);
                System.out.println("comando " + comando);


                if (comando.equalsIgnoreCase("salir")) {
                    out.writeUTF(comando);
                    String mensaje = in.readUTF();
                    sc.close();
                    System.out.println(mensaje);
                    break;
                } else {
                    out.writeUTF(comando);
                    String mensaje = in.readUTF();
                    System.out.println(mensaje);
                }
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
