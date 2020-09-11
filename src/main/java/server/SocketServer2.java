package server;

import utils.Request;

import java.io.*;
import java.net.ServerSocket;

public class SocketServer2 {
    public static void main(String[] args) {
        System.out.println("Starting server.");
        try {
            var clientSocket = new ServerSocket(12111).accept();
            var oOut = new ObjectOutputStream(clientSocket.getOutputStream());
            var bin = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            // For connection request
            var serverProtocol = new ServerProtocol();
            var response = serverProtocol.processRequest(new Request(""));
            oOut.writeObject(response);

            while (true) {
                String fromClient;
                while ((fromClient = bin.readLine()) != null) {
                    System.out.println("Given: " + fromClient);
                    oOut.writeObject(serverProtocol.processRequest(new Request(fromClient)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
