package Server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)
        ) {
            out.println("Connected to server! Type something...");

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client says: " + line);
                out.println("Server received: " + line);
            }
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
