package net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream in = null;
		try {
			serverSocket= new ServerSocket(8089);
			while(true) {
				socket = serverSocket.accept();
				String host = socket.getInetAddress().getHostAddress();
				System.out.println(host+"连接服务器....");
				os = socket.getOutputStream();
				in = socket.getInputStream();
				byte[] buf = new byte[1];
				int len = 0;
				String str = "";
				while((len = in.read(buf)) != -1) {
					System.out.println("每次接收的信息:"+new String(buf,0,len));
					str = str.concat(new String(buf,0,len).toString());
					System.out.println("str:"+str.toString());
				}
				System.out.println("接收来自客户端信息:"+str);
				os.write(str.getBytes());
				os.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
