package com.example.common.dao;

import com.example.common.model.User;

import java.util.List;

/**
 * Created by chenlin on 2019/11/15.
 */
public interface UserMapper {

    /**查询所有用户*/
    List<User> searchAll();
}
