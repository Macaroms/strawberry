package com.console.controller;

import com.console.feign.OrderServiceFeign;
import com.console.model.Result;
import com.console.service.IGoodService;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author jiangwei
 * @since 2022/6/25 11:55
 */
@Api(tags = "测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private OrderServiceFeign orderServiceFeign;

    @Resource
    private IGoodService goodService;

    @ApiOperation(value = "测试接口", notes = "测试接口")
    @GetMapping("/str")
    public Result<String> str(@ApiParam(value = "字符串", required = true) @RequestParam String str) {
        return Result.ok(str + " " + LocalDateTime.now());
    }

    @ApiOperation(value = "测试Order接口", notes = "测试Order接口")
    @GetMapping("/str1")
    public ResponseEntity<Result<String>> str1(@ApiParam(value = "字符串", required = true) @RequestParam String str) {
        Result<String> result = orderServiceFeign.orderTest(str);
        return ResponseEntity.status(result.getCode()).body(result);
    }

    @ApiOperation(value = "添加订单", notes = "添加订单")
    @GetMapping("/addOrder")
    public ResponseEntity<Result<String>> addOrder(@ApiParam(value = "商品ID", required = true) @RequestParam Long goodId,
                                                   @ApiParam(value = "描述信息") @RequestParam(required = false) String desc) {
        System.out.println("before add order: todo");
        // 测试sentinel降级
        orderServiceFeign.add(goodId, desc);
        System.out.println("after add order: todo");
        return ResponseEntity.ok(Result.ok("success"));
    }

    @ApiOperation(value = "减商品库存", notes = "减商品库存")
    @GetMapping("/decrease")
    public ResponseEntity<Result<String>> decrease(@ApiParam(value = "商品ID", required = true) @RequestParam Long id,
                                                   @ApiParam(value = "减少的数量", required = true) @RequestParam int count) {
        Result<String> result = goodService.decrease(id, count);
        return ResponseEntity.status(result.getCode()).body(result);
    }

    @ApiOperation(value = "测试分布式事务", notes = "测试分布式事务")
    @GetMapping("/seata")
    // @GlobalTransactional
    public ResponseEntity<Result<String>> seata(@ApiParam(value = "商品ID", required = true) @RequestParam Long id,
                                                @ApiParam(value = "减少的数量", required = true) @RequestParam int count,
                                                @ApiParam(value = "描述信息") @RequestParam(required = false) String desc
    ) {
        goodService.decrease(id, count);
        orderServiceFeign.add(id, desc);
        return ResponseEntity.ok(Result.ok("success"));
    }

}
