package com.git.lee.spring.boot.example.mapper;

import com.git.lee.spring.boot.example.ExApplication;
import com.git.lee.spring.boot.example.mapper.first.UserMapper;
import com.git.lee.spring.boot.example.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LISHUAIWEI
 * @date 2018/1/24 16:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExApplication.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void add() {
        User user = new User();
        user.setName("张三");
        userMapper.save(user);
    }

    @Test
    public void findById() {
        User user = userMapper.findById(1);
        Assert.assertEquals(user.getName(), "张三");
    }
}
