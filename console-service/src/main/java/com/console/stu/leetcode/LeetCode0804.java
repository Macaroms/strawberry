package com.console.stu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-12 19:55
 **/

public class LeetCode0804 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> res = subsets(arr);
        System.out.println(res);
    }
//0 1 2 3 4   01 02 03 04 12 13 14 23 24 34   012 013 014 023 024 034 123 124 134 234
    public static List<List<Integer>> subsets(int[] nums) {

        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;

    }

}
