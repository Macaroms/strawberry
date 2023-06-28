package com.console.stu.sort;

import java.util.Arrays;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-04-24 17:26
 **/

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 3, 1, 7, 8, 5};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arrays, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arrays[left];
        int temp;
        while (l < r) {
            while (pivot <= arrays[r] && l < r) {
                r--;
            }
            while (pivot >= arrays[l] && l < r) {
                l++;
            }
            if (l <= r) {
                temp = arrays[r];
                arrays[r] = arrays[l];
                arrays[l] = temp;
            }
        }
        arrays[left] = arrays[l];
        arrays[l] = pivot;
        sort(arrays, left, l - 1);
        sort(arrays, l + 1, right);
    }
}
