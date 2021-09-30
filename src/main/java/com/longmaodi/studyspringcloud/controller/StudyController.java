package com.longmaodi.studyspringcloud.controller;

import com.longmaodi.studyspringcloud.entity.User;
import com.longmaodi.studyspringcloud.service.StudyService;
import com.longmaodi.studyspringcloud.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Chang
 * @date: 2021/09/05 15:43
 **/
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
}
