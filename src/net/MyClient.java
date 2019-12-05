package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端服务端一对一聊一次
 * @author zjl
 *
 */
public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8089);
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		out.write("hello world!".getBytes());
		out.flush();
		byte[] buff = new byte[1024];
		int len = 0;
		while ((len = in.read(buff)) != -1) {
			System.out.println("接收服务器信息:"+new String(buff,0,len));
		}
		in.close();
		out.close();
		socket.close();
	}
}
