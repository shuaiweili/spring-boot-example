package com.git.lee.spring.boot.example.mapper;

import com.git.lee.spring.boot.example.model.Node;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 14:41
 */
@Repository
public interface NodeMapper {

    void save(Node node);

    Node findById(@Param("id") int id);
}
