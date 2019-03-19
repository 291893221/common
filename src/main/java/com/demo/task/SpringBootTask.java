package com.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SpringBootTask {
    private Logger logger = LoggerFactory.getLogger(SpringBootTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd HH:mm:ss");

    @Scheduled(cron = "0 */1 * * * ?")
    public void test() {
        logger.info("SpringBootTask 定时任务 {}", dateFormat.format(new Date()));
    }
}
