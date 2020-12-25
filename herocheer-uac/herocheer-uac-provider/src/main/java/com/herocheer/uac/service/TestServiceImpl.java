package com.herocheer.uac.service;

import com.alibaba.fastjson.JSONObject;
import com.herocheer.cache.bean.RedisClient;
import com.herocheer.common.exception.CommonException;
import com.herocheer.order.domain.entity.OrderTest;
import com.herocheer.order.service.OrderTestService;
import com.herocheer.uac.dao.TestDao;
import com.herocheer.uac.domain.entity.Test;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
@DubboService
@Slf4j
public class TestServiceImpl implements TestService{
    @Resource
    private TestDao testDao;
    @Resource
    private RedisClient redisClient;
    @DubboReference
    private OrderTestService orderTestService;


    @Override
    public Test get1(Long id) {
        return testDao.get(id);
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public Test getModel(Long id) {
        log.info("全局事务ID【{}】", RootContext.getXID());
        Test t = testDao.get(id);
        String key = "333333333";
        redisClient.set(key,"你是谁？我是谁？",10*1000);
        OrderTest orderTest = orderTestService.updateOrderTest();
        log.info("orderTest:{}", JSONObject.toJSONString(orderTest));
        testDao.insert(t);
        if(1 == 2){
            throw new CommonException("uac-provider异常");
        }
        t.setRemarks(redisClient.get(key));
        testDao.update(t);
        return t;
    }
}
