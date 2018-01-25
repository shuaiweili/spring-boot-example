package com.git.lee.spring.boot.example.model;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 14:12
 */
public enum  DataSourceType {
    MASTER("master"),
    SLAVE("slave");

    private String type;

    DataSourceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
