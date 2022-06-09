package com.decodeme.algorithm.tree;

import com.decodeme.leetcode.entity.TreeNode;

public class BalancedTree {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int result = helper(root);
    return result != -1;
  }

  private int helper(TreeNode root) {
    // 递归的出口,如果root节点为空时返回0
    if (root == null) {
      return 0;
    }
    // 递归左子树
    int left = helper(root.left);
    // 递归右子树
    int right = helper(root.right);
    // 如果左子树=-1,即为不平衡二叉树,那么整体就不为平衡二叉树,同理可得右边
    // 如果左边的深度与右边的深度相减大于1,则表示不是平衡二叉树,直接返回-1,退出递归
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    // 如果是平衡二叉树,则需要退出到上一步,返回他们的深度最大值
    return Math.max(left, right) + 1;
  }
}
