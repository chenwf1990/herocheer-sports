package com.herocheer.uac;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenwf
 * @date 2020/12/17
 */
@SpringBootApplication(scanBasePackages = {"com.herocheer.uac","com.herocheer.web"})
@EnableDubbo
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}