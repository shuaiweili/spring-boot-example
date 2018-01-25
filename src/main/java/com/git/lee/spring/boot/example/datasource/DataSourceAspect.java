package com.git.lee.spring.boot.example.datasource;

import com.git.lee.spring.boot.example.annotation.DataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 *  DataSource切面，用于动态改变数据源
 * @author LISHUAIWEI
 * @date 2018/1/25 18:42
 */
@Configuration
@Aspect
public class DataSourceAspect implements Ordered {

    @Before(value = "@annotation(dataSource)")
    public void dataSourcePoint(JoinPoint jp, DataSource dataSource) {
        DataSourceHolder.putDataSource(dataSource.value());
    }

    //order 越低，代表优先级越高
    @Override
    public int getOrder() {
        return -1;
    }
}
