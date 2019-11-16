package com.example.api.facade.impl;

import com.example.api.facade.UserFacade;
import com.example.common.dao.UserMapper;
import com.example.common.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenlin on 2019/11/15.
 */
@Service("userFacadeImpl")
@Slf4j
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserMapper userMapper;

    @Value("${test.api.one}")
    private String one;

    @Value("${test.api.two}")
    private String two;

    @Override
    public List<User> getUserAll() {
        log.info("获取用户信息");
        return userMapper.searchAll();
    }

    @Override
    public String readConfig() {
        log.info("获取配置信息，{}",one);
        log.info("获取配置信息，{}",two);
        return one+two;
    }
}
