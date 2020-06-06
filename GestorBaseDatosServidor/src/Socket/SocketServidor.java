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
import Modelo.Comando.Comando;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServidor {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        Scanner n = new Scanner(System.in);

        //puerto de nuestro servidor
        final int PUERTO = 5000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            //Espero a que un cliente se conecte
            sc = servidor.accept();

            System.out.println("Cliente conectado");
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF("Ingresa usuario:");
            in = new DataInputStream(sc.getInputStream());
            String usuario = in.readUTF();
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF("Ingresa contraseña:");
            in = new DataInputStream(sc.getInputStream());
            String contraseña = in.readUTF();
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(String.valueOf(Comando.getComando().usuarioPswCorrecto(usuario, contraseña)));
            
            if(!Comando.getComando().usuarioPswCorrecto(usuario, contraseña)){
                System.out.println("Usuario y/o contraseña incorrecta.");
                sc.close();
            }else{
            Comando comando = Comando.getComando();
            while (true) {

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                //Leo el mensaje que me envia
                String mensaje = in.readUTF();

                System.out.println(mensaje);

                String temporal[] = mensaje.split(" ");

                //Le envio un mensaje
                if (temporal[0].equals("CREAR")) {
                    System.out.println(temporal[0]);
                    if(temporal[1].equals("BD")){
                        System.out.println(temporal[1]);
                        System.out.println(temporal[2]);
                        if(comando.crearBD(temporal[2])){
                        out.writeUTF("Base de datos creada con exito.");
                        }else{
                        out.writeUTF("No se pudo crear la base de datos");
                    }
                    }
                    
                    if(temporal[1].equals("TABLA")){
                        if (temporal[3].equals("CAMPOS")) {
                    if (temporal.length > 3) {
                        String campos = temporal[4];
                        if (temporal.length > 4) {
                            for (int i = 5; i < temporal.length; i++) {
                                campos += "," + temporal[i];
                            }
                        }
                    } else {
                        System.err.println("Se requiere(n) nombre(s) del campo(s)");
                    }

                }
                    }
                    
                }
                
                
                
                if (mensaje.equalsIgnoreCase("salir")) {
                    out.writeUTF("Adios");
                    System.out.println("adios");
                    //Cierro el socket
                    sc.close();
                    System.out.println("Cliente desconectado");
                    break;
                }
                
                else{
                    out.writeUTF("Comando no reconocido");
                }

            }
            }

        } catch (IOException ex) {
            Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
