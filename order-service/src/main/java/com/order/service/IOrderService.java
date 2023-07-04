package com.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.order.entity.Order;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-29 16:47
 **/
public interface IOrderService extends IService<Order> {

    Page<Order> page(Page<Order> page);

    boolean add(Long goodId, String desc);



}
