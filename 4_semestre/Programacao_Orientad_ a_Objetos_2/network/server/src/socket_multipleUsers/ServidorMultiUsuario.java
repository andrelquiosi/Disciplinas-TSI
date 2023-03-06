package socket_multipleUsers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorMultiUsuario {

    public static void main(String[] args) throws Exception {

        try ( ServerSocket listener = new ServerSocket(59898)) {
            System.out.println("Servidor executando...");
            ExecutorService pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new ServicoSocket(listener.accept()));
            }
        }
    }

    private static class ServicoSocket implements Runnable {

        // Adicione um mapa para armazenar as conexões de cada usuário
        private static Map<Integer, PrintWriter> usuarios = new HashMap<>();

        private Socket socket;
        private static int counter = 0;
        private int id;
        private int mensagens;

        private ServicoSocket(Socket socket) {
            this.socket = socket;
            try {
                usuarios.put(this.id = counter++, new PrintWriter(socket.getOutputStream(), true));
            } catch (IOException e) {
            }
        }

        @Override
        public void run() {
            System.out.println("Conectado: " + socket);
            try {
                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//                PrintWriter out = usuarios.get(id);
                while (in.hasNextLine()) {
                    String listar = "/listar";
                    String enviar = "/enviar";
                    String linha = in.nextLine();
                    if (linha.equals(listar)) {
                        out.println("Lista de Clientes: " + usuarios.keySet().toString());

                    } else if (linha.contains(enviar)) {
                        // Extraia o ID do destinatário e a mensagem a partir da entrada do usuário
                        String[] tokens = linha.split(" ", 3);
                        int idDestinatario = Integer.parseInt(tokens[1]);
                        String mensagem = tokens[2];

                        // Envie a mensagem para o destinatário
                        out = usuarios.get(idDestinatario);
                        System.out.println(idDestinatario + ": "+mensagem);
                        if (out != null) {
                            out.println(id + ": " + mensagem);
                        }
                    } else {
                        out.println("Mensagem " + mensagens++ + " recebida");
                        System.out.println("Cliente " + id + ": " + linha);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
