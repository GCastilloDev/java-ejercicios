package SocketServidor;

import LogicaNegocio.Consulta.Consulta;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author @LastShadow
 */
public class SocketServidor {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        //Clases propias
        Consulta consulta = new Consulta();

        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("estoy después de crear el socket");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 5000.");
            System.exit(1);
        }

        Socket clienteSocket = null;

        try {
            clienteSocket = serverSocket.accept();
            System.out.println("estoy después de aceptar un cliente");
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

        String mensajeEntrada, mensajeSalida;
        String nombreBD = "";
        ArrayList<String> tablaTemporal = new ArrayList<>();

        out.println("Conectado al servidor");
        int i = 0;
        while (true) {

            System.out.println("Entre al ciclo");
            mensajeEntrada = in.readLine();
            System.out.println("Mensaje Cliente: " + mensajeEntrada);

            int opcion = Integer.parseInt(mensajeEntrada);

            if (mensajeEntrada.equalsIgnoreCase("bye")) {
                break;
            }

            switch (opcion) {
                case 1:
                    nombreBD = in.readLine();
                    if (consulta.crearBD(nombreBD)) {
                        mensajeSalida = "# BASE DE DATOS CREADA CON ÉXITO " + nombreBD;
                        out.println(mensajeSalida);
                    } else {
                        mensajeSalida = "# LA BASE DE DATOS NO PUDO SER CREADA " + nombreBD;
                        out.println(mensajeSalida);
                    }
                    break;
                case 2:
                    
                    String nombreTabla = in.readLine();
                    String camposTabla = in.readLine();
                    tablaTemporal.add(camposTabla);
//                    tablaTemporal.add("gustavo,castillo");
//                    tablaTemporal.add("ana elisa,castillo");
                    if (consulta.crearTabla(tablaTemporal, nombreBD, nombreTabla, camposTabla)) {
//                    System.out.println("Nombre Tabla: " + nombreTabla);
//                    System.out.println("Campos: " + camposTabla);
//                    System.out.println("NombreBD: " + nombreBD);
                        mensajeSalida = "# TABLA CREADA CON EXITO";
                        out.println(mensajeSalida);
                    } else {
                        mensajeSalida = "# HUBO UN ERROR AL CREAR LA TABLA";
                        out.println(mensajeSalida);
                    }
                    break;
                case 3:
                    //CONSULTA "SELECCIONAR"
                    
                    DataOutputStream flujoDeSalida = new DataOutputStream(clienteSocket.getOutputStream());
                    DataInputStream msgEntrada = new DataInputStream(clienteSocket.getInputStream());
                                    
                    String condicion = msgEntrada.readUTF();
                    String tablaConsultar = msgEntrada.readUTF();
                    mensajeSalida = consulta.consultarTabla(nombreBD, condicion, tablaConsultar);
                    System.out.println(mensajeSalida);
//                    mensajeSalida = "# SELECCIONAR";
//                    out.println(mensajeSalida);
                    flujoDeSalida.writeUTF(mensajeSalida);

                    break;
                case 4:
                    //CONSULTA "AGREGAR"
                    String tablaN = in.readLine();
                    String campos = in.readLine();
//                    mensajeSalida = "# AGREGAR";
                    mensajeSalida = consulta.agregar(nombreBD, tablaN, campos);
                    out.println(mensajeSalida);
                    break;
                case 5:
                    mensajeSalida = "# ELIMINAR";
                    out.println(mensajeSalida);
                    break;
                case 6:
                    mensajeSalida = "# ACTUALIZAR";
                    out.println(mensajeSalida);
                    break;
                default:
                    mensajeSalida = "# COMANDO NO RECONOCIDO";
                    out.println(mensajeSalida);
                    break;
            }
//            System.out.println("Mensaje cliente: " + mensajeEntrada);
//
//            mensajeSalida = "Mensaje recibido";
//            out.println(mensajeSalida);
        }

        out.close();
        in.close();
        clienteSocket.close();
        serverSocket.close();
    }

    private static DataInputStream DataInputStream(InputStream inputStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
