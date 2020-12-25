package com.herocheer.order.service;

import com.herocheer.cache.bean.RedisClient;
import com.herocheer.order.dao.OrderTestDao;
import com.herocheer.order.domain.entity.OrderTest;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
@DubboService
public class OrderTestServiceImpl implements OrderTestService {
    @Resource
    private OrderTestDao orderTestDao;
    @Resource
    private RedisClient redisClient;


    @Override
    public OrderTest updateOrderTest() {
        OrderTest orderTest = orderTestDao.get(1L);
        return orderTest;
    }
}