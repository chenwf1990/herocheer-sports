package com.herocheer.order.domain.entity;

import com.herocheer.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/25
 * @company 厦门熙重电子科技有限公司
 */
@Data
public class OrderTest extends BaseEntity {
    @ApiModelProperty("备注")
    private String remarks;
}
