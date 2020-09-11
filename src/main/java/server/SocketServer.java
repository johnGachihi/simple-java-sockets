/*
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class SocketServer {
    public static void main(String[] args) {
        try {
            var serverSocket = new ServerSocket(12111);
            var clientSocket = serverSocket.accept();
            var pout = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            var bin = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            var serverProtocol = new ServerProtocol();
            pout.println(serverProtocol.processRequest(null));

            String fromClient;
            while ((fromClient = bin.readLine()) != null) {
                pout.println(serverProtocol.processRequest(fromClient));
                System.out.println(fromClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
