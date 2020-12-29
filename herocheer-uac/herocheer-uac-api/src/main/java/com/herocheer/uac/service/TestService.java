package com.herocheer.uac.service;

import com.herocheer.common.base.Page.Page;
import com.herocheer.common.base.service.BaseService;
import com.herocheer.uac.domain.entity.Test;
import com.herocheer.uac.domain.vo.TestVo;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
public interface TestService extends BaseService<Test,Long> {

    Test get1(Long id);

    Test getModel(Long id);

    Page<Test> getPageTest(TestVo testVo);
}
