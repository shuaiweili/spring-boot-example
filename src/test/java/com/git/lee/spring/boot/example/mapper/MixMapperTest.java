package com.git.lee.spring.boot.example.mapper;

import com.git.lee.spring.boot.example.ExApplication;
import com.git.lee.spring.boot.example.mapper.first.UserMapper;
import com.git.lee.spring.boot.example.mapper.second.GroupMapper;
import com.git.lee.spring.boot.example.model.Group;
import com.git.lee.spring.boot.example.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author LISHUAIWEI
 * @date 2018/1/24 17:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExApplication.class)
public class MixMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;


    @Test
    public void findAll() {
        List<User> users = userMapper.findAll();
        Assert.assertTrue(users.size() > 0);

        List<Group> groups = groupMapper.findAll();
        Assert.assertTrue(groups.size() > 0);
    }
}
