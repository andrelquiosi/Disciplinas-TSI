package socket_multipleUsers;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Passe o endereco IP do servidor como argumento na linha de comando");
            return;
        }
        try ( Socket socket = new Socket(args[0], 59898)) {
            System.out.println("Entre com as linhas de texto e então Ctrl+D ou Ctrl+C para sair");
            Scanner scanner = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println(in.nextLine());
            }
        }
    }

}
