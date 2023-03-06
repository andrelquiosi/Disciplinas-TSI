
import java.io.*;
import java.net.*;

public class ClientSide {

    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;

    public ClientSide(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
            System.exit(1);
        } catch (IOException i) {
            System.out.println(i);
            System.exit(1);
        }

        String line = "";

        while (!line.equals("Bora parar?")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ClientSide client = new ClientSide("127.0.0.1", 5000);
    }
}
