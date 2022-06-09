package com.decodeme.algorithm.tree;

import com.decodeme.leetcode.entity.TreeNode;

import java.util.Stack;

/** 后序遍历 */
public class LastTraversal {

  public void lastTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    lastTraversal(root.left);
    lastTraversal(root.right);
    System.out.println(root.val);
  }

  public void lastTraversalWithStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode preNode = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (root.right == null || root.right == preNode) {
        System.out.println(root.val);
        preNode = root;
        root = null;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
  }
}

