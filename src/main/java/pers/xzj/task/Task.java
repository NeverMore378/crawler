package pers.xzj.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pers.xzj.pipeline.MyPipeline;
import pers.xzj.processor.Processor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

import javax.annotation.PostConstruct;

/**
 * @author: xzj
 * @description:
 * @time: 2020-11-23 22:25
 */

@Component
public class Task {
    @Autowired
    private Processor processor;

    @Autowired
    private MyPipeline myPipeline;

    @Autowired
    private RedisScheduler redisScheduler;


    @PostConstruct
    @Scheduled(cron = "0 0 0 * * ?")
    public void task() {
        System.out.println("begin");
        Spider.create(processor).addUrl("https://blog.csdn.net/nav/ai")
        .addPipeline(myPipeline).setScheduler(redisScheduler).start();
    }


}
