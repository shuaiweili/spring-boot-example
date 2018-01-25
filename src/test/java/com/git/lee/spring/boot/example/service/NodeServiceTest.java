package com.git.lee.spring.boot.example.service;

import com.git.lee.spring.boot.example.ExApplication;
import com.git.lee.spring.boot.example.model.Node;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 14:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExApplication.class)
public class NodeServiceTest {

    @Autowired
    private NodeService nodeService;

    @Test
    public void add() {
        nodeService.add(new Node("节点1"));
    }

    @Test
    public void find() {
        Node node = nodeService.findById(1);
        Assert.assertTrue(node.getName().equals("节点1"));
    }
}
