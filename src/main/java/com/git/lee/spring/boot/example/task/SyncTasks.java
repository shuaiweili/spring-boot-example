package com.git.lee.spring.boot.example.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author LISHUAIWEI
 * @date 2017/12/11 10:56
 */
@Slf4j
//@Component
public class SyncTasks {

    @Scheduled(fixedRate = 10000, initialDelay = 1)
    public void task1() throws InterruptedException {
        while (true) {
            log.info("task1 running ...");
            Thread.sleep(60000);
        }
    }

    @Async
    @Scheduled(fixedRate = 10000, initialDelay = 1)
    public void task2() throws InterruptedException {
        while (true) {
            log.info("task2 running ...");
            Thread.sleep(60000);
        }

    }
}
