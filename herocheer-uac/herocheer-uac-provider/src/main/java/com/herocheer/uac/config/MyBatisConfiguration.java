package com.herocheer.uac.config;

import com.herocheer.mybatis.intercept.IbatisInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @desc mybatis配置拦截bean
 * @author chenwf
 * @create 2020/12/21
 * @company 厦门熙重电子科技有限公司
 */
@Configuration
public class MyBatisConfiguration {
//    @Bean
//    public IbatisInterceptor ibatisInterceptor(){
//        IbatisInterceptor sqlStatsInterceptor = new IbatisInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("dialect", "mysql");
//        sqlStatsInterceptor.setProperties(properties);
//        return sqlStatsInterceptor;
//    }
}
