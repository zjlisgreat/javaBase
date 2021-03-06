package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端服务端一对一无序聊
 * @author zjl
 *
 */
public class Server {
	
	private static Socket socket = null;
	
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		try {
			serverSocket= new ServerSocket(8089);
			while(true) {
				System.out.println("等待用户连接...");
				socket = serverSocket.accept();
				String host = socket.getInetAddress().getHostAddress();
				System.out.println(host+"连接服务器....");
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							//接收客户端消息
							InputStream in = socket.getInputStream();
							InputStreamReader isr = new InputStreamReader(in);
							BufferedReader br = new BufferedReader(isr);
							while(true) {
								System.out.println(host+"客户端说:"+br.readLine());
							}
						} catch (IOException e) {
							System.out.println("用户退出!");
						}
					}
				}).start();
				new Thread(new Runnable() {
					@SuppressWarnings("resource")
					@Override
					public void run() {
						try {
							//发消息给客户端
							OutputStream os = socket.getOutputStream();
							OutputStreamWriter osw = new OutputStreamWriter(os);
							PrintWriter pw = new PrintWriter(osw,true);
							Scanner sc = new Scanner(System.in);
							while(true) {
								pw.println(sc.nextLine());
							}
						} catch (IOException e) {
							System.out.println("用户退出!");
						}
					}
				}).start();
			}
		} catch (IOException e) {
			System.out.println("用户退出!");
		}
	}
}
