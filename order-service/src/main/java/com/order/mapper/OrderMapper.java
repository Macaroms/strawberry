package com.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-29 16:46
 **/

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
