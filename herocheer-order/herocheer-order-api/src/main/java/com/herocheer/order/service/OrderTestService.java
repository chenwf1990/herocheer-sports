package com.herocheer.order.service;

import com.herocheer.common.base.service.BaseService;
import com.herocheer.order.domain.entity.OrderTest;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
public interface OrderTestService extends BaseService<OrderTest,Long> {

    OrderTest updateOrderTest();
}
