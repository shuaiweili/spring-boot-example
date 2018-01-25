package com.git.lee.spring.boot.example.config;

import com.git.lee.spring.boot.example.datasource.DynamicDataSource;
import com.git.lee.spring.boot.example.model.DataSourceType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *  动态获取DataSource 实现读写分离
 * @author LISHUAIWEI
 * @date 2018/1/25 13:57
 */
@Configuration
@PropertySource(value = "classpath:datasource.properties")
@MapperScan(value = "com.git.lee.spring.boot.example.mapper")
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "master.datasource")
    public DataSource masterDataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "slave.datasource")
    public DataSource slaveDataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    //动态获取数据源
    @Bean(name = "dynamicDataSource")
    @Primary
    public DataSource getDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources());
        return dataSource;
    }

    private Map<Object, Object> targetDataSources() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.getType(), masterDataSource());
        targetDataSources.put(DataSourceType.SLAVE.getType(), slaveDataSource());
        return targetDataSources;
    }
}
