package network;

import java.net.Socket;

public class TCPClient3 {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 8080);
		System.out.println("client3 connected to server");
		socket.close();
	}

}
