package network;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		//server socket to response connection request
		//prototype <-> singletone
		//create instance when needed <-> create one instance and use address
		ServerSocket server = new ServerSocket(8080);
		System.out.println("TCP Server launched");
		System.out.println("waiting Client request");
		
		int count = 0;
		while(true) {
			Socket socket = server.accept();
			count++;
			System.out.println("Successed to server connection " + count);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("hello network!");
		}
	}

}
