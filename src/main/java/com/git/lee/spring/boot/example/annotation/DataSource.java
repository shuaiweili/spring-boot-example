package com.git.lee.spring.boot.example.annotation;

import com.git.lee.spring.boot.example.model.DataSourceType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface DataSource {
    DataSourceType value() default DataSourceType.MASTER;
}
