package com.herocheer.order.service;

import com.herocheer.cache.bean.RedisClient;
import com.herocheer.mybatis.base.service.BaseServiceImpl;
import com.herocheer.order.dao.OrderTestDao;
import com.herocheer.order.domain.entity.OrderTest;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
@DubboService
public class OrderTestServiceImpl extends BaseServiceImpl<OrderTestDao,OrderTest,Long> implements OrderTestService {
    @Resource
    private RedisClient redisClient;


    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
//    @Transactional
    public OrderTest updateOrderTest() {
        OrderTest orderTest = this.dao.get(1L);
        orderTest.setRemarks("123345");
        this.dao.update(orderTest);
        return orderTest;
    }
}
