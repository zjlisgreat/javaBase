package utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitConnectionUtil {
	
	private static final String RABBIT_IP= "localhost";
	private static final int RABBIT_PORT = 5672;
	private static final String RABBIT_USERNAME = "guest";
	private static final String RABBIT_PASSWORD = "guest";
	private static Connection connection;
	
	public static Connection getConnection() {
		if(connection == null) {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(RABBIT_IP);
			factory.setPort(RABBIT_PORT);
			factory.setUsername(RABBIT_USERNAME);
			factory.setPassword(RABBIT_PASSWORD);
			try {
				connection = factory.newConnection();
				System.out.println(connection);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection);
	}
}
