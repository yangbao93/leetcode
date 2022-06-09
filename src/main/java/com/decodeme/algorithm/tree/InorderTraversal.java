package com.decodeme.algorithm.tree;

import com.decodeme.leetcode.entity.TreeNode;

import java.util.Stack;

/** 中序遍历 */
public class InorderTraversal {

  public void inorderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left);
    System.out.println(root.val);
    inorderTraversal(root.right);
  }

  public void inorderTraversalWithStack(TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      System.out.println(root.val);
      root = root.right;
    }
  }
}
