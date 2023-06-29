package com.console.feign;

import com.console.feign.fallback.OrderServiceFallback;
import com.console.model.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-28 17:52
 **/
@FeignClient(value = "order", fallback = OrderServiceFallback.class)
public interface OrderServiceFeign {

    @ApiOperation(value = "OrderService测试接口", notes = "OrderService测试接口")
    @GetMapping("/api/order/orderTest")
    Result<String> orderTest(@ApiParam(value = "字符串", required = true) @RequestParam String str);

    @ApiOperation(value = "生成订单", notes = "生成订单")
    @GetMapping("/api/order/add")
    Result<String> add(@ApiParam(value = "商品ID", required = true) @RequestParam Long goodId,
                       @ApiParam(value = "描述信息") @RequestParam(required = false) String desc);

}
