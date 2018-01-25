package com.git.lee.spring.boot.example.model;

import lombok.Data;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 14:39
 */
@Data
public class Node {
    private int id;
    private String name;

    public Node() {

    }

    public Node(String name) {
        this.name = name;
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
