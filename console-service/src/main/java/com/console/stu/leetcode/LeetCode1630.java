package com.console.stu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-15 11:19
 **/

public class LeetCode1630 {

    //输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
    //输出：[true,false,true]
    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int m = l.length;
        for (int i = 0; i < m; i++) {
            int left = l[i], right = r[i];
            int[] arr = new int[right - left + 1];
            if (right + 1 - left >= 0) System.arraycopy(nums, left, arr, 0, right + 1 - left);
            list.add(isEqualMinusArr(arr));
        }
        return list;
    }

    private static boolean isEqualMinusArr(int[] arr){
        if(arr.length<2){
            return true;
        }
        Arrays.sort(arr);
        int minus = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != minus) {
                return false;
            }
        }
        return true;
    }

}
