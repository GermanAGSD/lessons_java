package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Server_socket {
    static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void server() throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for connection...");

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Client connected!");

            ClientHandler client = new ClientHandler(clientSocket);
            clients.add(client);

            Thread thread = new Thread(client);
            thread.start();
        }
    }

}
