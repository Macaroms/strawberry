package com.console.stu.sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-04-24 17:37
 **/

public class Test {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.addFirst(4);

//        Integer e1 = deque.element();
//        Integer e2 = deque.getFirst();
//        Integer e3 = deque.peek();
//        Integer poll = deque.poll();
        Integer pop = deque.pop();
        deque.push(8);

        System.out.println(pop);



        System.out.println(deque);
    }

}
