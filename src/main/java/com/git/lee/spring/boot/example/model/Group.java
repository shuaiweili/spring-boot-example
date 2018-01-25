package com.git.lee.spring.boot.example.model;

import lombok.Data;

/**
 * @author LISHUAIWEI
 * @date 2018/1/24 16:35
 */
@Data
public class Group {
    private int id;
    private String name;

    public Group(){}

    public Group(String name) {
        this.name = name;
    }
}
