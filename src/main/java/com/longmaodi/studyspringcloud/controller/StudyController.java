package com.longmaodi.studyspringcloud.controller;

import com.longmaodi.studyspringcloud.entity.User;
import com.longmaodi.studyspringcloud.service.StudyService;
import com.longmaodi.studyspringcloud.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Chang
 * @date: 2021/09/05 15:43
 **/
@Slf4j
@RestController
@RequestMapping("/study")
public class StudyController {

    @Autowired
    private StudyService studyService;

    @PostMapping("/testInsert")
    public RestResponse testInsert(@RequestBody User user) {
        studyService.insert(user);
        return RestResponse.success();
    }

    @GetMapping("/testGet")
    private RestResponse testKafka(@RequestParam String aa) {
        log.info("收到请求{}", aa);
        return RestResponse.success(aa);
    }
}
