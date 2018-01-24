package com.git.lee.spring.boot.example.mapper.second;

import com.git.lee.spring.boot.example.model.Group;

import java.util.List;

/**
 * @author LISHUAIWEI
 * @date 2018/1/24 16:36
 */
public interface GroupMapper {

    void save(Group group);

    List<Group> findAll();
}
