package com.console.stu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-13 16:34
 **/

public class LeetCode007 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
    }
//[[-2,0,2],[-2,1,1]]
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            int left = i+1;
            int right = nums.length -1;
            while (left < right){
                if(ele + nums[left] + nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!res.contains(list)){
                        res.add(list);
                    }
                    left += 1;
                } else if (ele + nums[left] + nums[right] < 0){
                    left += 1;
                } else if (ele + nums[left] + nums[right] > 0){
                    right -= 1;
                }
            }
        }
        return res;
    }

}
