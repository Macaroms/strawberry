package com.order.enums;

import java.util.Arrays;
import java.util.List;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-25 09:25
 **/
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "系统内部异常"),
    ;

    public static final List<Integer> successCodes = Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 304);
    private final Integer code;

    private final String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}

