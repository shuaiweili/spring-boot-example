package com.git.lee.spring.boot.example.mapper;

import com.git.lee.spring.boot.example.ExApplication;
import com.git.lee.spring.boot.example.mapper.second.GroupMapper;
import com.git.lee.spring.boot.example.model.Group;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author LISHUAIWEI
 * @date 2018/1/24 16:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExApplication.class)
public class GroupMapperTest {
    @Autowired
    private GroupMapper groupMapper;


    @Test
    public void add() {
        Group group = new Group();
        group.setName("自定义");
        groupMapper.save(group);
    }

    @Test
    public void findAll() {
        List<Group> groups = groupMapper.findAll();
        Assert.assertTrue(groups.size() > 0);
    }
}
