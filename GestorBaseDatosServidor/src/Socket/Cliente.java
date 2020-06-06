/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

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
            
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            String respuesta = n.nextLine();
            out.writeUTF(respuesta);
            mensaje = in.readUTF();
            System.out.println(mensaje);
            respuesta = n.nextLine();
            out.writeUTF(respuesta);
            mensaje = in.readUTF();
            
            if(mensaje.equals("true")){

            while(true){
                System.out.print("> ");
                String comando = n.nextLine();
                //Envio un mensaje al cliente


                if (comando.equalsIgnoreCase("salir")) {
                    out.writeUTF(comando);
                    mensaje = in.readUTF();
                    sc.close();
                    System.out.println("Adios...ad");
                    break;
                } else {
                    out.writeUTF(comando);
                    String m = in.readUTF();
                    System.out.println(m);
                }
                
            }
            }else{
                System.out.println("Usuario y/o contraseña incorrecta.");
            }

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
