package com.example.api.facade;

import com.example.common.model.User;

import java.util.List;

/**
 * Created by chenlin on 2019/11/15.
 */
public interface UserFacade {

    List<User> getUserAll();

    String readConfig();
}
