package com.longmaodi.studyspringcloud.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author ChangLF 2023-03-08
 */
@Slf4j
@Component
public class TestListener {

    @KafkaListener(topics = {"test2"}, groupId = "cloud")
    public void listen1(String data) {
        log.info("kafka接收消息："  +data);
    }
}
