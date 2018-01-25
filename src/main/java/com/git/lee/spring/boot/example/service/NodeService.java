package com.git.lee.spring.boot.example.service;

import com.git.lee.spring.boot.example.annotation.DataSource;
import com.git.lee.spring.boot.example.mapper.NodeMapper;
import com.git.lee.spring.boot.example.model.DataSourceType;
import com.git.lee.spring.boot.example.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 14:46
 */
@Service
public class NodeService {
    @Autowired
    private NodeMapper nodeMapper;

    @DataSource(DataSourceType.SLAVE)
    @Transactional(rollbackFor = Exception.class)
    public void add(Node node) {
        nodeMapper.save(node);
    }

    @DataSource(DataSourceType.MASTER)
    public Node findById(int id) {
        return nodeMapper.findById(id);
    }
}
