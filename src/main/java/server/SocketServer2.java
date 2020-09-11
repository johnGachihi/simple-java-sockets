package server;

import utils.Request;

import java.io.*;
import java.net.ServerSocket;

public class SocketServer2 {
    public static void main(String[] args) {
        try {
            var serverSocket = new ServerSocket(12111);
            var clientSocket = serverSocket.accept();
            var oOut = new ObjectOutputStream(clientSocket.getOutputStream());
            var bin = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            var serverProtocol = new ServerProtocol();
            var response = serverProtocol.processRequest(new Request(""));
            oOut.writeObject(response);

            while (true) {
                String fromClient;
                while ((fromClient = bin.readLine()) != null) {
                    oOut.writeObject(serverProtocol.processRequest(new Request(fromClient)));
                    System.out.println(fromClient);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
