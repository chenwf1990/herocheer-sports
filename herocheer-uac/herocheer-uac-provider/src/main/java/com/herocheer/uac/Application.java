package com.herocheer.uac;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenwf
 * @date 2020/12/17
 */
@SpringBootApplication(scanBasePackages = {"com.herocheer"})
@MapperScan(basePackages = {"com.herocheer.uac.dao"})
@EnableAutoDataSourceProxy
@EnableDubbo
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
