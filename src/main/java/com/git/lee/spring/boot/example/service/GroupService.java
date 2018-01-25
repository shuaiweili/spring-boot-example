package com.git.lee.spring.boot.example.service;

import com.git.lee.spring.boot.example.mapper.second.GroupMapper;
import com.git.lee.spring.boot.example.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 11:00
 */
//@Service
public class GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Transactional(rollbackFor = Exception.class, transactionManager = "secondTransactionManager")
    public void add(Group group) throws Exception {
        groupMapper.save(group);
//        throw new Exception("添加group时出现异常");
    }
}
