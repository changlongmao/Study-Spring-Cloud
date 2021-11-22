package com.longmaodi.studyspringcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.hook.ConsumeMessageContext;
import org.apache.rocketmq.client.hook.ConsumeMessageHook;

/**
 * @author: ChangLF
 * @date: 2021/11/01 11:00
 **/
@Slf4j
public class ConsumerTestHook implements ConsumeMessageHook {

    @Override
    public String hookName() {
        return ConsumerTestHook.class.getName();
    }

    @Override
    public void consumeMessageBefore(ConsumeMessageContext consumeMessageContext) {
        log.info("execute consumeMessageBefore. consumeMessageContext: {}",consumeMessageContext);
    }

    @Override
    public void consumeMessageAfter(ConsumeMessageContext consumeMessageContext) {
        log.info("execute consumeMessageAfter. consumeMessageContext: {}",consumeMessageContext);
    }
}
