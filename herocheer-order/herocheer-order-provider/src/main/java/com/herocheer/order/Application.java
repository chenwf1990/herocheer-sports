package com.herocheer.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenwf
 * @date 2020/12/17
 */
@SpringBootApplication(scanBasePackages = {"com.herocheer"})
@MapperScan(basePackages = {"com.herocheer.order.dao"})
@EnableDubbo
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
