package rabbitmq.helloword;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import utils.RabbitConnectionUtil;

public class Consumer {
	
	private static final String QUEUE_NAME = "test_queue";
	
	public static void main(String[] args) throws IOException {
		Connection connection = RabbitConnectionUtil.getConnection();
		Channel channel = connection.createChannel(1);
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		StringBuffer message = new StringBuffer();
		com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag,Envelope envelope,BasicProperties basicProperties,byte[] body) throws IOException {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				super.handleDelivery(consumerTag,envelope,basicProperties,body);
				message.append(new String(body,"utf-8"));
				System.out.println(new String(body,"utf-8"));
			}
		};
		channel.basicConsume(QUEUE_NAME, true,consumer);
		System.out.println(message.toString());
		
	}
}
