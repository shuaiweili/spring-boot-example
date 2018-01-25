package com.git.lee.spring.boot.example.service;

import com.git.lee.spring.boot.example.mapper.first.UserMapper;
import com.git.lee.spring.boot.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 10:58
 */
//@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class, transactionManager = "firstTransactionManager")
    public void add(User user) throws Exception {
        userMapper.save(user);
        throw new Exception("添加user时出现异常");
    }
}
