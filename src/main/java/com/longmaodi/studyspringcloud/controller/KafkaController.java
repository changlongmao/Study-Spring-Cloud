package com.longmaodi.studyspringcloud.controller;

import com.longmaodi.studyspringcloud.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChangLF 2023-03-08
 */
@RequestMapping("/kafka")
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/testKafka")
    private RestResponse testKafka(@RequestParam String aa) {
        kafkaTemplate.send("test2", aa);
        kafkaTemplate.send("test1", aa);
        kafkaTemplate.send("demo", aa);

        return RestResponse.success();
    }
}
