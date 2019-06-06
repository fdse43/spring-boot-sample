package com.cn.boot.sample.amqp.test1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <p>Title:</p>
 * <p>Description:</p>
 *
 * @author Chen Nan
 * @date 2019/6/2.
 */
@Component
@Slf4j
public class Product1 {
    static {
        try {
            init();
        } catch (IOException | TimeoutException e) {
            log.error("Consumer1:", e);
        }
    }

    public static void init() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        log.info("开始发送");
        String content = "Hello RabbitMQ!";
        channel.basicPublish("", "test01", null, content.getBytes());
        log.info("发送成功");

        channel.close();
        connection.close();
    }
}
