package com.myself.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Date;

/**
 * @program: cloud2020
 * @description:
 * @create: 2020-07-22 22:12
 **/

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class MicrocourseScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicrocourseScheduleApplication.class, args);
    }
    /**
     * 每分钟 一次
     */
    @Scheduled(fixedDelay = 60*1000)
    @Async
    public void playSth() {
        System.out.println("早点回家、、" + DateFormat.getDateTimeInstance().format(new Date()));
    }
    /**
     * 没小时一次
     */
    @Async
    @Scheduled(fixedDelay = 60*60*1000)
    public void playSth2() {
        System.out.println("早点吃饭、、" + DateFormat.getDateTimeInstance().format(new Date()));
    }

}
