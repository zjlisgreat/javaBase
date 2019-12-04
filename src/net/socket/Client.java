package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private  static Socket socket = null;
	
	public static void main(String[] args) {
		try {
			socket = new Socket("localhost", 8089);
			String host = socket.getInetAddress().getHostAddress();
			new Thread(new Runnable() {
				@SuppressWarnings("resource")
				@Override
				public void run() {
					try {
						//向服务器发消息
						OutputStream os = socket.getOutputStream();
						OutputStreamWriter osw = new OutputStreamWriter(os);
						PrintWriter pw = new PrintWriter(osw);
						Scanner sc = new Scanner(System.in);
						pw.println(sc.next());
						pw.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						//接收服务器发过来得消息
						InputStream in = socket.getInputStream();
						InputStreamReader isr = new InputStreamReader(in);
						BufferedReader br = new BufferedReader(isr);
						while(true) {
							System.out.println(host+"服务器说:"+br.readLine());
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
