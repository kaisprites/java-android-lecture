package DBConnect;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class WebServer {

	public static void main(String[] args) {
		ServerSocket server = new ServerSocket(9000);
		
		while (true) {
			Socket socket = server.accept();
			System.out.println("클라이언트");
		}
	}

}
