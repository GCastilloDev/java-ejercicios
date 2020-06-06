/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclienteservidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author @LastShadow
 */
public class Cliente {

    public static void main(String[] args) throws IOException {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            kkSocket = new Socket("localhost", 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: manis.csi.ull.es.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: manis.csi.ull.es.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

//        while ((fromServer = in.readLine()) != null) {
//            System.out.println("Server: " + fromServer);
//            if (fromServer.equals("Bye.")) {
//                break;
//            }
//
//            fromUser = stdIn.readLine();
//            if (fromUser != null) {
//                System.out.println("Client: " + fromUser);
//                out.println(fromUser);
//            }
//        }
        while (true) {
            System.out.println("Server: " + fromServer);
            if (fromServer.equals("Bye.")) {
                break;
            }

            fromUser = stdIn.readLine();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
            }
        }

        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
}
