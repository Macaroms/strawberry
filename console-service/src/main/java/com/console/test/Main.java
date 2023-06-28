package com.console.test;

import java.util.Arrays;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-12 16:55
 **/

public class Main {
    public static void main(String[] args) {
        String str = "a,,,fa,,sdfa,a";
        System.out.println(Arrays.toString(str.split(",")));
    }
}
