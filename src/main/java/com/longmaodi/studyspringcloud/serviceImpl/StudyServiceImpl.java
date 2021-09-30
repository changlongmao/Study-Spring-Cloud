package com.longmaodi.studyspringcloud.serviceImpl;

import com.longmaodi.studyspringcloud.entity.User;
import com.longmaodi.studyspringcloud.mapper.UserMapper;
import com.longmaodi.studyspringcloud.service.StudyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: Chang
 * @date: 2021/09/05 15:45
 **/
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class StudyServiceImpl implements StudyService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.batchInsert(Collections.singletonList(user));
    }
}
