
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSide {

    private ServerSocket server = null;

    public ServerSide(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            ExecutorService pool = Executors.newCachedThreadPool();
            while (true) {
                pool.execute(new ClientHandler(server.accept()));
            }
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        ServerSide server = new ServerSide(5000);
    }
}
