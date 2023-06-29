package com.console.feign.fallback;

import com.console.feign.OrderServiceFeign;
import com.console.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-29 17:23
 **/

@Component
@Slf4j
public class OrderServiceFallback implements OrderServiceFeign {
    @Override
    public Result<String> orderTest(String str) {
        return null;
    }

    @Override
    public Result<String> add(Long goodId, String desc) {
        log.error("add order failed, goodId:{}, desc: {}", goodId, desc);
        return Result.fail("add order failed");
    }

    public static void main(String[] args) {
        System.out.println("阿阿阿");
    }
}
