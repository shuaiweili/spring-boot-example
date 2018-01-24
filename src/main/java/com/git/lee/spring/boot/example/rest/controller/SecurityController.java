package com.git.lee.spring.boot.example.rest.controller;

import com.git.lee.spring.boot.example.rest.config.WebSecurityConfig;
import com.git.lee.spring.boot.example.rest.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LISHUAIWEI
 * @date 2018/1/8 15:32
 */
@Controller
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> toLogin(String account, String password, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        if (!securityService.isValid(account, password)) {
            result.put("status", "fail");
            result.put("message", "用户名或密码错误");
            return result;
        }
        //设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, account);
        result.put("status", "success");
        result.put("message", "登录成功");
        return result;
    }
}
