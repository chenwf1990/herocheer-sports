package com.herocheer.uac.service;

import com.herocheer.uac.domain.entity.Test;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
public interface TestService{

    Test get1(Long id);

    Test getModel(Long id);
}
