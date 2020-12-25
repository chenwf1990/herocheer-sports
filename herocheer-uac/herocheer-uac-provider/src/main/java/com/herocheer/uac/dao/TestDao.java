package com.herocheer.uac.dao;

import com.herocheer.mybatis.base.BaseDao;
import com.herocheer.uac.domain.entity.Test;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
public interface TestDao extends BaseDao<Test,Long> {

    Test findOne(Long id);
}
