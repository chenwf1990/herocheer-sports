package com.herocheer.uac.service;

import com.herocheer.cache.bean.RedisClient;
import com.herocheer.common.exception.CommonException;
import com.herocheer.uac.dao.TestDao;
import com.herocheer.uac.domain.entity.Test;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
@DubboService
public class TestServiceImpl implements TestService{
    @Resource
    private TestDao testDao;
    @Resource
    private RedisClient redisClient;


    @Override
    public Test get1(Long id) {
        return testDao.get(id);
    }

    @Override
    public Test getModel(Long id) {
        Test t = testDao.get(id);
        String key = "333333333";
        redisClient.set(key,"你是谁？我是谁？",10*1000);
        t.setRemarks(redisClient.get(key));
        testDao.update(t);
//        testDao.insert(t);
//        if(true){
//            throw new CommonException("uac-provider异常");
//        }
        return t;
    }
}
