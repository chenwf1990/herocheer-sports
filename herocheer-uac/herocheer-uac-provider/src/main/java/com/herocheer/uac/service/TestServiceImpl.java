package com.herocheer.uac.service;

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


    @Override
    public Test get1(Long id) {
        return testDao.get(id);
    }

    @Override
    public Test getModel(Long id) {
        Test t = testDao.get(id);
        t.setRemarks("123456");
        testDao.update(t);
        t.setId(null);
        t.setRemarks(System.currentTimeMillis()+"");
        testDao.insert(t);
//        if(true){
//            throw new CommonException("uac-provider异常");
//        }
        return t;
    }
}
