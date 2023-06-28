package com.console.stu.leetcode;

import java.util.HashMap;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-13 16:15
 **/

public class LeetCode2661 {

    public static void main(String[] args) {

    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int len = arr.length;
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hashMap.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < len; i++) {
            int ele = arr[i];
            if (hashMap.containsKey(ele)) {
                int x = hashMap.get(ele)[0];
                int y = hashMap.get(ele)[1];
                row[x]++;
                col[y]++;
                if (row[x] == n || col[y] == m) {
                    return i;
                }
            }
        }

        return -1;
    }

}
