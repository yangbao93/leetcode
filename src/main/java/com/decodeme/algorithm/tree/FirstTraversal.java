package com.decodeme.algorithm.tree;

import com.decodeme.leetcode.entity.TreeNode;

import java.util.Stack;

/** 前序遍历 */
public class FirstTraversal {

  public void firstTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.println(root.val);
    firstTraversal(root.left);
    firstTraversal(root.right);
  }

  public void firstTraversalWithStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    while (stack.isEmpty() && root != null) {
      while (root != null) {
        System.out.println(root.val);
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      root = root.right;
    }
  }
}
