package br.com.projetofinal.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NodeServer {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(7000);
                while (true) {
                    Socket socket = server.accept();
                    new Thread(new NodeResolver(socket)).start();
                }
            } catch (IOException ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        }).start();
    }

}
