package SocketCliente;

import LogicaNegocio.Agregar;
import LogicaNegocio.CrearBD;
import LogicaNegocio.CrearTabla;
import LogicaNegocio.MensajeEntrada;
import LogicaNegocio.Seleccionar;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author @LastShadow
 */
public class SocketCliente {

    public static void main(String[] args) throws IOException {

        Socket kkSocket = null;
        PrintWriter out = null;
        PrintWriter opcionConsulta = null;
        BufferedReader in = null;
        Scanner n = null;
        MensajeEntrada consulta = null;
        PrintWriter nombreBD = null;

        //Clases propias
        CrearBD bd = new CrearBD();
        CrearTabla tabla = new CrearTabla();
        Seleccionar seleccionar = new Seleccionar();
        Agregar agregar = new Agregar();

        try {
            kkSocket = new Socket("localhost", 5000);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            opcionConsulta = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            n = new Scanner(System.in);
            consulta = new MensajeEntrada();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: manis.csi.ull.es.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: manis.csi.ull.es.");
            System.exit(1);
        }

        String mensajeServidor;
        String mensajeSalida;

        mensajeServidor = in.readLine();
        System.out.println(mensajeServidor);

        while (true) {

            System.out.print("> ");
            mensajeSalida = n.nextLine();

            int opcion = consulta.consultaRequerida(mensajeSalida);

            if (mensajeSalida.equalsIgnoreCase("bye")) {
                System.exit(1);
                break;
            }

            switch (opcion) {
                case 1:
                    out.println(opcion);
                    nombreBD = new PrintWriter(kkSocket.getOutputStream(), true);
                    out.println(bd.nombreBD(mensajeSalida));
                    mensajeServidor = in.readLine();
                    System.out.println(mensajeServidor);
                    break;
                case 2:
                    out.println(opcion);
                    String nombreTabla = tabla.nombreTabla(mensajeSalida);
                    String campos = tabla.camposTabla(mensajeSalida);
                    out.println(nombreTabla);
                    out.println(campos);
                    mensajeServidor = in.readLine();
                    System.out.println(mensajeServidor);
                    break;
                case 3:
                    //CONSULTA SELECCIONAR
                    DataOutputStream flujoDeSalida = new DataOutputStream(kkSocket.getOutputStream());
                    DataInputStream msgEntrada = new DataInputStream(kkSocket.getInputStream());

                    out.println(opcion);
                    String condicion = seleccionar.condicion(mensajeSalida);
                    String tablaConsultar = seleccionar.tabla(mensajeSalida);
//                    out.println(condicion);
//                    out.println(tablaConsultar);
                    flujoDeSalida.writeUTF(condicion);
                    flujoDeSalida.writeUTF(tablaConsultar);
                    mensajeServidor = msgEntrada.readUTF();
                    System.out.println(mensajeServidor);
                    break;
                case 4:
                    //CONSULTA AGREGAR DATOS
                    out.println(opcion);
                    String nombreT = agregar.nombreTabla(mensajeSalida);
                    String campo = agregar.campos(mensajeSalida);
                    out.println(nombreT);
                    out.println(campo);
                    mensajeServidor = in.readLine();
                    System.out.println(mensajeServidor);
                    break;
                case 5:
                    out.println(opcion);
                    mensajeServidor = in.readLine();
                    System.out.println(mensajeServidor);
                    break;
                case 6:
                    out.println(opcion);
                    mensajeServidor = in.readLine();
                    System.out.println(mensajeServidor);
                    break;
                default:
                    out.println(opcion);
                    mensajeServidor = in.readLine();
                    System.out.println(mensajeServidor);
                    break;
            }

        }

        out.close();
        in.close();
        kkSocket.close();
    }

    private static DataInputStream DataInputStream(InputStream inputStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
