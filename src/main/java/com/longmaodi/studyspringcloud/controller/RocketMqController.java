package com.longmaodi.studyspringcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ChangLF
 * @date: 2021/10/29 17:54
 **/
@Slf4j
@RestController
@RequestMapping("/rocketMq")
public class RocketMqController {
    public static final String TOPIC = "DemoTopic";
    private static String TAGS = "glmapperTags";

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping("send")
    public String send() throws Throwable {
        // 创建 Demo01Message 消息
        Message message = new Message();
        // oneway 发送消息
        rocketMQTemplate.sendOneWay(TOPIC, "测试发送消息");

        return "SUCCESS";
    }
}
