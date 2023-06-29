package com.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order.entity.Order;
import com.order.model.Result;
import com.order.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jiangwei
 * @since 2022/6/25 11:55
 */
@Api(tags = "Order测试")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @ApiOperation(value = "测试接口", notes = "测试接口")
    @GetMapping("/orderTest")
    public Result<String> orderTest(@ApiParam(value = "字符串", required = true) @RequestParam String str) {
        return Result.ok("order-test");
    }

    @ApiOperation(value = "order列表", notes = "order列表")
    @GetMapping("/page")
    public Result<Page<Order>> page(@ApiParam(value = "页码", required = true, defaultValue = "1")
                                    @RequestParam int pageNum,
                                    @ApiParam(value = "页大小", required = true, defaultValue = "10")
                                    @RequestParam int pageSize) {

        return Result.ok(orderService.page(new Page<>(pageNum, pageSize)));
    }

}
