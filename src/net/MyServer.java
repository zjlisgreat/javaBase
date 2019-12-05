package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端服务端一对一聊一次
 * @author zjl
 *
 */
public class MyServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new  ServerSocket(8089);
		Socket socket = serverSocket.accept();
		System.out.println(socket.getInetAddress().getHostAddress()+"连接上了！");  
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		out.write("你好,服务器欢迎你!".getBytes());
		byte[] b = new byte[1024];
		int len = 0 ;
		while((len =in.read(b))!= -1) {
			System.out.println("接收客户端数据："+new String(b,0,len));
		}
		out.close();
		in.close();
		serverSocket.close();
		socket.close();
	}
}
