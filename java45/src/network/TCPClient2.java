package network;

import java.net.Socket;

public class TCPClient2 {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 8080);
		System.out.println("client2 connected to server");
		socket.close();
	}

}
