package com.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-29 16:36
 **/

@Data
@TableName(value = "t_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单号")
    private Long orderNumber;

    @ApiModelProperty(value = "商品编号")
    private Long goodId;

    @ApiModelProperty(value = "详情")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
