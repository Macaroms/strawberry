package com.console.feign;

import com.console.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-28 17:52
 **/
@FeignClient(value = "order")
public interface OrderServiceFeign {

    @ApiOperation(value = "OrderService测试接口", notes = "OrderService测试接口")
    @GetMapping("/test/orderTest")
    ResponseEntity<Result<String>> orderTest(@ApiParam(value = "字符串", required = true) @RequestParam String str);

}
