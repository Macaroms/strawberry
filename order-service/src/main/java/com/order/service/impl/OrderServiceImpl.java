package com.order.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.entity.Order;
import com.order.mapper.OrderMapper;
import com.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-29 16:48
 **/

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public Page<Order> page(Page<Order> page) {
        return this.page(page, null);
    }

    @Override
    public boolean add(Long goodId, String desc) {
        log.info("添加订单");
        return false;
    }
}
