package com.console.stu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-12 17:47
 **/

public class LeetCode781 {

    //森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
    //给你数组 answers ，返回森林中兔子的最少数量。
    //
    //示例 1：
    //输入：answers = [1,1,2]
    //输出：5
    //解释：
    //两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
    //之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
    //设回答了 "2" 的兔子为蓝色。
    //此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
    //因此森林中兔子的最少数量是 5 只：3 只回答的和 2 只没有回答的。
    //
    //示例 2：
    //输入：answers = [10,10,10]
    //输出：11
    //
    //提示：
    //    1 <= answers.length <= 1000
    //    0 <= answers[i] < 1000
    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{0, 0, 1, 1, 1}));//11
    }

    public static int numRabbits(int[] answers) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            if (map.containsKey(answer)) {
                map.put(answer, map.get(answer) + 1);
            } else {
                map.put(answer, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getKey() + 1;
            if (entry.getValue() <= count) {
                result += count;
            } else {
                int group = entry.getValue() % (count) == 0 ? entry.getValue() / (count) : (entry.getValue() / (count) + 1);
                result += group * (count);
            }
        }
        return result;
    }

}
