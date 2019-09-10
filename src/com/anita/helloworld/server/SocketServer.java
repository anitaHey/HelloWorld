package com.anita.helloworld.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable {
    private static SocketServer server;
    private ServerSocket serverSocket;
    private Socket socket;
    private final int Port = 8080;

    public SocketServer() {
        try{
            serverSocket = new ServerSocket(Port);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static SocketServer getInstance() {
        if(server == null) {
            server = new SocketServer();
        }

        return server;
    }

    @Override
    public void run() {
        try {
            synchronized (serverSocket) {
                socket = serverSocket.accept();
            }
            System.out.println("Connect Address:" + socket.getInetAddress());

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String word = reader.readLine();
            System.out.println("Get word:" + word);

            socket.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
