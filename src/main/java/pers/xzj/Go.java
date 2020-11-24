package pers.xzj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import us.codecraft.webmagic.scheduler.RedisScheduler;

import javax.xml.ws.Holder;

/**
 * @author: xzj
 * @description: go
 * @time: 2020-11-23 22:26
 */

@SpringBootApplication
public class Go {

    @Value("${spring.redis.host}")
    private String host;

    public static void main(String[] args) {
        SpringApplication.run(Go.class);
    }

    @Bean
    public RedisScheduler redisScheduler(){
        return new RedisScheduler(host);
    }
}
