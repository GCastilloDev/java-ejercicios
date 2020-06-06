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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author @LastShadow
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("estoy después de crear el socket");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("estoy después de aceptar un cliente");
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;

        out.println("Conectado al servidor");
        while (true) {

            inputLine = in.readLine();
            System.out.println("Mensaje cliente: " + inputLine);
            
            outputLine = "Mensaje recibido";
            out.println(outputLine);
            
            if(inputLine.equalsIgnoreCase("bye")){
                break;
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

}
