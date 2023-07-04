package com.console.entity;

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
@TableName(value = "t_good")
public class Good {

    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String goodName;

    @ApiModelProperty(value = "库存")
    private Integer reserve;

    @ApiModelProperty(value = "所属")
    private String owner;

    @ApiModelProperty(value = "价格")
    private Double price;

}
