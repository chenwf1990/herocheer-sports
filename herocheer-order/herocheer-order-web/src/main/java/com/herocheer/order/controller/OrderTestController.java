package com.herocheer.order.controller;

import com.herocheer.cache.bean.RedisClient;
import com.herocheer.common.base.ResponseResult;
import com.herocheer.order.service.OrderTestService;
import com.herocheer.web.annotation.AllowAnonymous;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenwf
 * @date 2020/12/17
 */
@RestController
@RequestMapping("/order")
@Api(tags = "测试模块")
public class OrderTestController {
    @DubboReference()
    private OrderTestService orderTestService;
    @Resource
    private RedisClient redisClient;

    @GetMapping("/test")
    @ApiOperation("订单测试")
    @AllowAnonymous
    public ResponseResult updateOrderTest(){
//        redisClient.set("1234","我是redis");
//        Test test = testService.getModel(1L);
//        test.setRemarks(redisClient.get("1234"));
//        if(true){
//            throw new CommonException("可是挨晒付好款");
//        }
//        test = testService.updateTest(test);
//        try {
//        }catch (CommonException e){
//            e.printStackTrace();
//        }
        return ResponseResult.ok().setData("");
    }
}
