package com.longmaodi.studyspringcloud.rocketmq;

import com.longmaodi.studyspringcloud.controller.RocketMqController;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Chang
 * @date: 2021/10/29 17:19
 **/
@Slf4j
//@Component
@RocketMQMessageListener(
        topic = RocketMqController.TOPIC,
        consumerGroup = "${spring.application.name}" + "A" + RocketMqController.TOPIC,
        maxReconsumeTimes = 2
)
public class ConsumerA implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("[onMessage][线程编号:{} A消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
