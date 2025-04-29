package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Server_socket {
    ArrayList<NetClient> clients = new ArrayList<>();
    ServerSocket server;
    Server_socket() throws IOException {
        server = new ServerSocket(1234);
    }

    public void run(){
        while (true) {

            try {
                Socket clientSocket = server.accept();
                System.out.println("Client connected!");

                ClientHandler client = new ClientHandler(clientSocket);

                Thread thread = new Thread(client);
                thread.start(); // запускаем обработку клиента в отдельном потоке
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void server() throws IOException {

    }


}
