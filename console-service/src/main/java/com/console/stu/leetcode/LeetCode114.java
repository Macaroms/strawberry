package com.console.stu.leetcode;

import com.console.stu.leetcode.pojo.TreeNode;
import com.console.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-12 16:14
 **/

public class LeetCode114 {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *     展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     *     展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * 示例 1：
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     *
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：root = [0]
     * 输出：[0]
     *
     * 提示：
     *     树中结点数在范围 [0, 2000] 内
     *     -100 <= Node.val <= 100
     */
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,5,3,4,null,6};
        TreeNode root = TreeNodeUtil.arrayToTreeNode(arr);
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            prev.left = null;
            prev.right = list.get(i);
        }
    }

    public static void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

}

