package client;

import utils.Request;
import utils.Response;
import utils.Step;

import java.io.*;
import java.net.Socket;

public class SocketClient2 {
    private final String address;
    private final ClientProtocol clientProtocol;
    private Socket serverSocket;
    private ObjectInputStream oIn;
    private PrintWriter pout;

    public SocketClient2(String address, ClientProtocol clientProtocol) {
        this.address = address;
        this.clientProtocol = clientProtocol;
    }

    public Step connect() throws IOException, ClassNotFoundException {
        serverSocket = new Socket(address, 12111);
        pout = new PrintWriter(serverSocket.getOutputStream(), true);
        oIn = new ObjectInputStream(serverSocket.getInputStream());

        return clientProtocol.getStep((Response) oIn.readObject());
    }

    public Step makeRequest(Request request) throws Exception {
        if (serverSocket == null || ! serverSocket.isConnected()) {
            throw new Exception("Connection not established. Please call SocketClient2.connect()");
        }

        pout.println(request.getMessage());

        return clientProtocol.getStep((Response) oIn.readObject());
    }
}

