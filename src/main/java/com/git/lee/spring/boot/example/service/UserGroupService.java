package com.git.lee.spring.boot.example.service;

import com.git.lee.spring.boot.example.model.Group;
import com.git.lee.spring.boot.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 9:54
 */
//@Service
public class UserGroupService {
    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    public void handle() {
        try {
            userService.add(new User("王五"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            groupService.add(new Group("自定义2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
