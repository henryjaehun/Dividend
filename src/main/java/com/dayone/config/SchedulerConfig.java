package com.dayone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulerConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler threadPool = new ThreadPoolTaskScheduler();

        int n = Runtime.getRuntime().availableProcessors(); // 코어갯수 가져올수 있음
        threadPool.setPoolSize(n); // 쓰레드의 갯수 설정
        threadPool.initialize();

        taskRegistrar.setTaskScheduler(threadPool); // 스케줄러에서 우리가 생성한 스레드풀을 사용하게 해줌
    }
}
