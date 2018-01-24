package com.git.lee.spring.boot.example.mapper.first;

import com.git.lee.spring.boot.example.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LISHUAIWEI
 * @date 2018/1/24 16:34
 */
public interface UserMapper {

    void save(User user);

    List<User> findAll();

    User findById(@Param("id")int id);
}
