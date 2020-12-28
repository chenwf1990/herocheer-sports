package com.herocheer.uac.controller;

import com.herocheer.cache.bean.RedisClient;
import com.herocheer.common.base.ResponseResult;
import com.herocheer.common.base.page.Page;
import com.herocheer.uac.domain.entity.Test;
import com.herocheer.uac.domain.vo.TestVo;
import com.herocheer.uac.service.TestService;
import com.herocheer.web.annotation.AllowAnonymous;
import com.herocheer.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author chenwf
 * @date 2020/12/17
 */
@RestController
@RequestMapping("/hero")
@Api(tags = "测试模块")
public class TestController extends BaseController {
    @DubboReference
    private TestService testService;
    @Resource
    private RedisClient redisClient;

    @GetMapping("/test")
    @ApiOperation("测试")
    @AllowAnonymous
    public ResponseResult updateTest(){
        redisClient.set("1234","我是redis");
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
        return ResponseResult.ok().setData(test);
    }


    @GetMapping("/page")
    @ApiOperation("分页测试")
    @AllowAnonymous
    public ResponseResult pageTest(){
        Page<Test> testPage = testService.getPageTest(new TestVo());
        return ResponseResult.ok().setData(testPage);
    }
}
