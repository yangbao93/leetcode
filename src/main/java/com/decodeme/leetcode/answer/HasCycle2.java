package com.decodeme.leetcode.answer;

import com.decodeme.leetcode.entity.ListNode;

public class HasCycle2 {
  public ListNode hasCycle2(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode fastNode = head, slowNode = head;
    boolean haveCycle = false;
    // 防止head只有一个数据,next直接为空是,fastNode.next.next就是空指针;
    // 因为fastNode一次走两步,所以只需要看fastNode的next与next.next是否为空就行
    while (fastNode.next != null && fastNode.next.next != null) {
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
      if (fastNode == slowNode) {
        haveCycle = true;
        break;
      }
    }
    if (haveCycle) {
      slowNode = head;
      while (slowNode != fastNode) {
        slowNode = slowNode.next;
        fastNode = fastNode.next;
      }
      return slowNode;
    }
    return null;
  }
}
