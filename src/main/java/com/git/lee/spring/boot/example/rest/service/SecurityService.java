package com.git.lee.spring.boot.example.rest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author LISHUAIWEI
 * @date 2018/1/8 16:16
 */
@Service
public class SecurityService {

    @Value("${login.username}")
    private String username;
    @Value("${login.password}")
    private String password;

    public boolean isValid(String account, String pwd) {
        return username.equals(account) && password.equals(pwd);
    }
}
