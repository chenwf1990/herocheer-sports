package com.herocheer.uac.dao;

import com.herocheer.common.base.page.Page;
import com.herocheer.mybatis.base.dao.BaseDao;
import com.herocheer.uac.domain.entity.Test;
import com.herocheer.uac.domain.vo.TestVo;

import java.util.List;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/24
 * @company 厦门熙重电子科技有限公司
 */
public interface TestDao extends BaseDao<Test,Long> {

    Test findOne(Long id);

    List<Test> listByPage(Page a);

    List<Test> listByPage(TestVo testVo);
}
