package com.decodeme.algorithm.linkedlist;

import com.decodeme.leetcode.entity.ListNode;
import com.decodeme.util.NodeUtil;

/** 反转链表 */
public class ReserveLinkedNode {

  public ListNode reserveMethod1(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode result = reserveMethod1(head.next);
    ListNode node = result;
    while (node != null) {
      if (node.next == null) {
        node.next = head;
        head.next = null;
        break;
      } else {
        node = node.next;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ListNode node = NodeUtil.toLinkedList(1, 2, 3, 4, 5);
    ListNode reserveNode = new ReserveLinkedNode().reserveMethod1(node);
    while (reserveNode != null) {
      System.out.println(reserveNode.val);
      reserveNode = reserveNode.next;
    }
  }
}
