package com.git.lee.spring.boot.example.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author LISHUAIWEI
 * @date 2017/11/7 10:50
 */
@SpringBootApplication
@EnableScheduling
public class DynamicTaskApp {

    public static void main(String[] args) {
        SpringApplication.run(DynamicTaskApp.class, args);
    }
}
