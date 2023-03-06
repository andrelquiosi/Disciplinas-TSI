package UDP_ClienteServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPCliente {

	public static void main(String args[]) throws Exception {

		BufferedReader inUsuario = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clienteSocket = new DatagramSocket();
		InetAddress enderecoIP = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String string = inUsuario.readLine();
		sendData = string.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, enderecoIP, 9876);
		clienteSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clienteSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("Servidor diz:" + modifiedSentence);
		clienteSocket.close();
	}

}
