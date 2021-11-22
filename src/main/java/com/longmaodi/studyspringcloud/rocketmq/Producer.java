package com.longmaodi.studyspringcloud.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author: Chang
 * @date: 2021/10/29 17:16
 **/
public class Producer {

    public static void main(String[] args) throws Exception {
        // 指定生产组名为my-producer
        DefaultMQProducer producer = new DefaultMQProducer("my-producer");
        // 配置namesrv地址
        producer.setNamesrvAddr("1.15.104.25:9876");
        producer.setSendMsgTimeout(60000);
        // 启动Producer
        producer.start();
        // 创建消息对象，topic为：myTopic001，消息内容为：hello world
        Message msg = new Message("myTopic001", "hello world".getBytes());
        // 发送消息到mq，同步的
        SendResult result = producer.send(msg);
        System.out.println("发送消息成功！result is : " + result);
        // 关闭Producer
        producer.shutdown();
        System.out.println("生产者 shutdown！");
    }
}
