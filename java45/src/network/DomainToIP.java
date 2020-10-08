package network;

import java.net.InetAddress;

//domain name: www.naver.com
//DNS(domain name system) server: ip address
public class DomainToIP {

	public static void main(String[] args) throws Exception {
		String domain = "www.amazon.com";
		InetAddress ip = InetAddress.getByName(domain);
		System.out.println("ip 주소: " + ip.getHostAddress());
	}

}
