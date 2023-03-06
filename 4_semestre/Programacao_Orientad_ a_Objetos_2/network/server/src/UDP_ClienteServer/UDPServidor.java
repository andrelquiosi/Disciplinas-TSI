package UDP_ClienteServer;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServidor {

    public static void main(String args[]) throws Exception {

        DatagramSocket servidorSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            servidorSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("Recebido: " + sentence);
            InetAddress enderecoIP = receivePacket.getAddress();
            int porta = receivePacket.getPort();
            String capitalizedString = sentence.toUpperCase();
            sendData = capitalizedString.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, enderecoIP, porta);
            servidorSocket.send(sendPacket);
        }
    }

}
