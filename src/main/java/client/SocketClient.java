package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            var serverSocket = new Socket("localhost", 12111);
            var bin = new BufferedReader(
                    new InputStreamReader(serverSocket.getInputStream()));
            var pout = new PrintWriter(serverSocket.getOutputStream(), true);

            String fromServer;
            var sysIn = new BufferedReader(new InputStreamReader(System.in));
            while ((fromServer = bin.readLine()) != null) {
                System.out.println(fromServer);
                pout.println(sysIn.readLine());
            }
            var serverMessage = bin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
