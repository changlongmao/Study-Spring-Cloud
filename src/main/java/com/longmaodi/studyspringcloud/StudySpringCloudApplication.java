package com.longmaodi.studyspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class StudySpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringCloudApplication.class, args);
    }

}
