package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(8080);
		System.out.println("receive socket launched");
		System.out.println("receiver ready");
		byte[] data = new byte[256];
		DatagramPacket packet = new DatagramPacket (data, data.length);
		socket.receive(packet);
		System.out.println("받은 데이터: " + new String(packet.getData()));
		socket.close();
	}

}
