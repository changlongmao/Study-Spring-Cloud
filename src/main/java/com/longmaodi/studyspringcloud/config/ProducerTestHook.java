package com.longmaodi.studyspringcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.hook.SendMessageContext;
import org.apache.rocketmq.client.hook.SendMessageHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息发送之前、之后拦截
 *
 * @author: ChangLF
 * @date: 2021/11/01 10:32
 **/
@Slf4j
public class ProducerTestHook implements SendMessageHook {

    @Override
    public String hookName() {
        return ProducerTestHook.class.getName();
    }

    @Override
    public void sendMessageBefore(SendMessageContext sendMessageContext) {
        log.info("execute sendMessageBefore. sendMessageContext:{}", sendMessageContext);
    }

    @Override
    public void sendMessageAfter(SendMessageContext sendMessageContext) {
        log.info("execute sendMessageAfter. sendMessageContext:{}", sendMessageContext);
    }
}
