package com.decodeme.leetcode.answer;

import com.decodeme.leetcode.entity.ListNode;

public class IsPalindrome {
  public boolean isPalindrome(ListNode head) {
    // 首先利用快慢指针找到中间的链表值
    ListNode fast = head, slow = head;
    // fast一次走两步,当链表长度为偶数时,fast指向null,slow指向一半;当链表长度为奇数时,fast指向最后一个值,slow指向中间的值
    while (fast.next != null && fast != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // 当链表长度为奇数时,slow需要再向后移动一个
    if (fast != null) {
      slow = slow.next;
    }
    // 将slow后面的链表进行反转
    slow = reserve(slow);

    // 将fast再指向head
    fast = head;
    // 如果奇数个,不需要管最后fast的next;如果是偶数个,fast与slow同时到达最后;
    while (slow != null) {
      if (fast.val != slow.val) {
        return false;
      }
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }

  private ListNode reserve(ListNode head) {
    ListNode preNode = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = preNode;
      preNode = head;
      head = next;
    }
    return preNode;
  }
}
