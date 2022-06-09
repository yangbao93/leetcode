package com.decodeme.leetcode.answer;

import com.decodeme.leetcode.entity.ListNode;

public class HasCycle1 {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode fastNode = head, slowNode = head;
    // 防止head只有一个数据,next直接为空是,fastNode.next.next就是空指针;
    // 因为fastNode一次走两步,所以只需要看fastNode的next与next.next是否为空就行
    while (fastNode.next != null && fastNode.next.next != null) {
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
      if (fastNode == slowNode) {
        return true;
      }
    }
    return false;
  }
}
