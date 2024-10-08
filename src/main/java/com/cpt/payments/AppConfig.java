package com.cpt.payments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfig {						// customize threadpool 


    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        
        executor.setCorePoolSize(5);					//number of thread keep in pool , even if they are idle
        executor.setMaxPoolSize(10);					//max number of thread allowed in pool
        executor.setQueueCapacity(25);					//queue capacity
        executor.setThreadNamePrefix("MyExecutor-");    //prefix name   ex-  MyExecutor-task-1
        executor.initialize();
        return executor;
    }
}
