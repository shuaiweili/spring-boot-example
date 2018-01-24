package com.git.lee.spring.boot.example.task;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author LISHUAIWEI
 * @date 2017/11/7 11:04
 */
//@Component
public class WorkTask implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addTriggerTask(() -> {
//            //run task
//            System.out.println("run task at " + new Date().toString());
//        }, triggerContext -> {
//            //config trigger cron
//            CronTrigger trigger = new CronTrigger(getCron());
//            return trigger.nextExecutionTime(triggerContext);
//        });
    }

    private String getCron() {
        //reload cron
        Config config = ConfigFactory.load("task.conf");
        return config.getString("task.cron");
    }
}
