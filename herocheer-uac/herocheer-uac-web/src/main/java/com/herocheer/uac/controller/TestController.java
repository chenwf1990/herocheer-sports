package com.herocheer.uac.controller;

import com.herocheer.common.base.ResponseResult;
import com.herocheer.common.exception.CommonException;
import com.herocheer.uac.domain.entity.Test;
import com.herocheer.uac.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenwf
 * @date 2020/12/17
 */
@RestController
@RequestMapping("/hero")
@Api(tags = "测试模块")
public class TestController {
    @DubboReference()
    private TestService testService;
//    @Resource
//    private RedisClient redisClient;

    @GetMapping("/test")
    @ApiOperation("测试")
    public ResponseResult updateTest(){
//        redisClient.set("1234","我是redis");
        Test test = testService.getModel(1L);
//        test.setRemarks(redisClient.get("1234"));
//        if(true){
//            throw new CommonException("可是挨晒付好款");
//        }
//        test = testService.updateTest(test);
//        try {
//        }catch (CommonException e){
//            e.printStackTrace();
//        }
        test.setRemarks("可是挨晒付好款");
        return ResponseResult.ok().setData(test);
    }
}
