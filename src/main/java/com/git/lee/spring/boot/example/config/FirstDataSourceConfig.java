package com.git.lee.spring.boot.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author LISHUAIWEI
 * @date 2018/1/24 15:17
 */
@Configuration
@MapperScan(value = "com.git.lee.spring.boot.example.mapper.first", sqlSessionFactoryRef = "firstSqlSessionFactory")
@EnableConfigurationProperties(MybatisProperties.class)
public class FirstDataSourceConfig {

    private MybatisProperties mybatisProperties;

    public FirstDataSourceConfig(MybatisProperties properties) {
        this.mybatisProperties = properties;
    }

    @Bean(name = "firstDataSource")
    @Primary
    @ConfigurationProperties(prefix = "first.datasource")
    public DataSource getDataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }


    @Bean(name = "firstSqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setMapperLocations(mybatisProperties.resolveMapperLocations());
        sessionFactory.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
        sessionFactory.setConfiguration(SqlSessionFactoryConfigUtil.clone(mybatisProperties.getConfiguration()));
        return sessionFactory.getObject();
    }

}
