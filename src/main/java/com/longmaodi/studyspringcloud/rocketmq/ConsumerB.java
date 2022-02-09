package com.longmaodi.studyspringcloud.rocketmq;

import com.longmaodi.studyspringcloud.controller.RocketMqController;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author: Chang
 * @date: 2021/10/29 17:19
 **/
@Slf4j
//@Component
@RocketMQMessageListener(
        topic = RocketMqController.TOPIC,
        consumerGroup = "${spring.application.name}" + "B" + RocketMqController.TOPIC,
        maxReconsumeTimes = 2
)
public class ConsumerB implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("[onMessage][线程编号:{} B消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
