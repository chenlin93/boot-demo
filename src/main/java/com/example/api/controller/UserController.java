package com.example.api.controller;

import com.example.api.facade.UserFacade;
import com.example.util.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by chenlin on 2019/11/15.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Resource(name = "userFacadeImpl")
    private UserFacade userFacade;

    /**
     * 查询用户信息
     * */
    @PostMapping("/getAll")
    public Results getUserAll(){
        log.info("获取所有用户信息");
        return Results.success(userFacade.getUserAll());
    }

    /**
     * 读取配置信息
     * */
    @PostMapping("/readConfig")
    public Results readConfig(){
        log.info("读取配置信息");
        return Results.success(userFacade.readConfig());
    }

}
