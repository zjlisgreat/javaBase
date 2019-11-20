package net;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class NetDemo {
	public static void main(String[] args) throws UnknownHostException, MalformedURLException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println(inetAddress.getHostAddress());
		System.out.println(inetAddress.getHostName());
		System.out.println(inetAddress.getAddress());
		System.out.println(inetAddress.getCanonicalHostName());
		
//		URL url = new URL("");
	}
}
