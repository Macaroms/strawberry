package com.console.controller;

import com.console.feign.OrderServiceFeign;
import com.console.model.Result;
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
 * @since  2022/6/25 11:55
 */
@Api(tags = "测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    OrderServiceFeign orderServiceFeign;

    @ApiOperation(value = "测试接口", notes = "测试接口")
    @GetMapping("/str")
    public ResponseEntity<Result<String>> str(@ApiParam(value = "字符串", required = true) @RequestParam String str) {
        return ResponseEntity.ok(Result.ok(str + " " + LocalDateTime.now()));
    }

    @ApiOperation(value = "测试Order接口", notes = "测试Order接口")
    @GetMapping("/str1")
    public ResponseEntity<Result<String>> str1(@ApiParam(value = "字符串", required = true) @RequestParam String str) {
        return ResponseEntity.ok(orderServiceFeign.orderTest(str));
    }

}
