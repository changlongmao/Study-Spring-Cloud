package com.longmaodi.studyspringcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ChangLF
 * @date: 2021/10/29 17:47
 **/
@Slf4j
//@Configuration
public class MQConsumerConfiguration {

    @Value("${rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.consumer.groupName}")
    private String groupName;

    @Value("${rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;

    @Value("${rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;

    // 订阅指定的 topic
    @Value("${rocketmq.consumer.topics}")
    private String topics;
    @Value("${rocketmq.consumer.consumeMessageBatchMaxSize}")
    private int consumeMessageBatchMaxSize;

    @Autowired
    private MessageListenerHandler mqMessageListenerProcessor;

//    @Bean
    @ConditionalOnMissingBean
    public DefaultMQPushConsumer defaultMQPushConsumer() throws RuntimeException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.registerMessageListener(mqMessageListenerProcessor);
        // 注册 ConsumeMessageHook
        consumer.getDefaultMQPushConsumerImpl().registerConsumeMessageHook(new ConsumerTestHook());
        // 设置 consumer 第一次启动是从队列头部开始消费还是队列尾部开始消费
        // 如果非第一次启动，那么按照上次消费的位置继续消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 设置消费模型，集群还是广播，默认为集群
        consumer.setMessageModel(MessageModel.CLUSTERING);
        // 设置一次消费消息的条数，默认为 1 条
        consumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);

        try {
            // 设置该消费者订阅的主题和tag，如果是订阅该主题下的所有tag，使用*；
            consumer.subscribe(topics, "*");
            // 启动消费
            consumer.start();
            log.info("consumer is started. groupName:{}, topics:{}, namesrvAddr:{}", groupName, topics, namesrvAddr);

        } catch (Exception e) {
            log.error("failed to start consumer . groupName:{}, topics:{}, namesrvAddr:{}", groupName, topics,
                    namesrvAddr, e);
            throw new RuntimeException(e);
        }
        return consumer;
    }
}
