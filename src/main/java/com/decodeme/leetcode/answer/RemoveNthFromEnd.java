package com.decodeme.leetcode.answer;

import com.decodeme.leetcode.entity.ListNode;

/**
 * 删除链表中倒数第N个节点
 */
public class RemoveNthFromEnd {
    //    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    //
    //    示例：
    //
    //    给定一个链表: 1->2->3->4->5, 和 n = 2.
    //
    //    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    //    说明：
    //
    //    给定的 n 保证是有效的。
    //
    //    进阶：
    //
    //    你能尝试使用一趟扫描实现吗？

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        remove(head, n);
        return head;
    }

    private static int remove(ListNode head, int target) {
        int i = 1;
        if (head.next != null) {
            i = remove(head.next, target);
        }
        if (target == 1 && i == (target + 1)) {
            head.next = null;
        }
        if (target == i && target > 1) {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        int result = i + 1;
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        removeNthFromEnd(head, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
