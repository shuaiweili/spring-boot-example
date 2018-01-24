package com.git.lee.spring.boot.example.config;

import org.apache.ibatis.session.Configuration;

/**
 * @author LISHUAIWEI
 * @date 2018/1/24 17:21
 */
public class SqlSessionFactoryConfigUtil {

    public static Configuration clone(Configuration from) {
        Configuration configuration = new Configuration(from.getEnvironment());
        configuration.setMapUnderscoreToCamelCase(from.isMapUnderscoreToCamelCase());
        return configuration;
    }
}
