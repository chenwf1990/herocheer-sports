package com.herocheer.uac.service;

import com.herocheer.cache.bean.RedisClient;
import com.herocheer.common.base.page.Page;
import com.herocheer.mybatis.base.service.BaseServiceImpl;
import com.herocheer.order.service.OrderTestService;
import com.herocheer.uac.dao.TestDao;
import com.herocheer.uac.domain.entity.Test;
import com.herocheer.uac.domain.vo.TestVo;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
@DubboService
@Slf4j
public class TestServiceImpl extends BaseServiceImpl<TestDao,Test,Long> implements TestService{
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
        Test t = this.dao.get(id);
        String key = "333333333";
        redisClient.set(key,"你是谁？我是谁？",10*1000);
//        OrderTest orderTest = orderTestService.updateOrderTest();
//        log.info("orderTest:{}", JSONObject.toJSONString(orderTest));
//        testDao.insert(t);
//        if(1 == 2){
//            throw new CommonException("uac-provider异常");
//        }
        t.setRemarks(redisClient.get(key));
        testDao.update(t);
        return t;
    }

    @Override
    public Page<Test> getPageTest(TestVo testVo) {

        Test t = new Test();
        t.setId(1l);
        t.setRemarks("2131231");
        this.dao.update(t);
        Page<Test> page = Page.startPage(1,10);
        List<Test> list = this.dao.listByPage(testVo);
        page.setDataList(list);
        return page;
    }
}
