
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket = null;
    private DataInputStream in = null;
    

    @Override
    public void run() {
        try {
            System.out.println("Client accepted");
            
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";

            while (true) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch (EOFException i) {
                    break;
                } catch (IOException i) {
                    System.out.println(i);
                }
            }

            System.out.println("Closing connection");
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

}
