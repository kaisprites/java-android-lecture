package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient1 {

	public static void main(String[] args) throws Exception {
		for(int i=0; i<1000; i++) {
			Socket socket = new Socket("localhost", 8080);
			System.out.println("client " + (i+1) + " connected to server");
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Reader: 2byte, InputStream: 1byte; InputStreamReader works like bridge 
			
			String data = input.readLine();
			System.out.println("받은 데이터: " + data);
			input.close();
			socket.close();
		}
	}

}
