package com.decodeme.util;

import com.decodeme.leetcode.entity.ListNode;

public class NodeUtil {

  public static ListNode toLinkedList(int... params) {
    ListNode result = new ListNode(params[0]);
    ListNode tmpNodeHead = result;
    for (int i = 1; i < params.length; i++) {
      tmpNodeHead.next = new ListNode(params[i]);
      tmpNodeHead = tmpNodeHead.next;
    }
    return result;
  }
}
