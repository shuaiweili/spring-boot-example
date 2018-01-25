package com.git.lee.spring.boot.example.datasource;

import com.git.lee.spring.boot.example.model.DataSourceType;

/**
 * @author LISHUAIWEI
 * @date 2018/1/25 14:30
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static void putDataSource(DataSourceType dataSourceType) {
        holder.set(dataSourceType.getType());
    }

    public static String getDataSource(){
        return holder.get();
    }
}
