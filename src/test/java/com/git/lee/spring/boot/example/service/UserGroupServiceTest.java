package com.git.lee.spring.boot.example.service;

import com.git.lee.spring.boot.example.ExApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 10:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExApplication.class)
public class UserGroupServiceTest {
    @Autowired
    private UserGroupService userGroupService;

    @Test
    public void handleRollback() throws Exception {
        userGroupService.handle();
    }
}
