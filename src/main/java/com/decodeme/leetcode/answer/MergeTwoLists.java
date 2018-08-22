package com.decodeme.leetcode.answer;

import com.decodeme.leetcode.entity.ListNode;

/**
 * 合并两个链表
 */
public class MergeTwoLists {

    //    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //
    //    示例：
    //
    //    输入：1->2->4, 1->3->4
    //    输出：1->1->2->3->4->4
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        if (l1 == null && l2 == null) {
            return result;
        }
        while (l1 != null || l2 != null) {
            if (l1 == null) {
               result = addVal(result,l2.val);
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                result = addVal(result,l1.val);
                l1 = l1.next;
                continue;
            }
            if (l1.val <= l2.val) {
                result = addVal(result, l1.val);
                l1 = l1.next;
            } else {
                result = addVal(result,l2.val);
                l2 = l2.next;
            }
        }
        return result;
    }

    private static ListNode addVal(ListNode result, int val) {
        if (result == null) {
            result = new ListNode(val);
            return result;
        }
        ListNode copy = result;
        while (copy != null) {
            if (copy.next == null) {
                copy.next = new ListNode(val);
                return result;
            }
            copy = copy.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        ListNode list5 = new ListNode(1);
        ListNode list6 = new ListNode(2);
        ListNode list7 = new ListNode(3);
        ListNode list8 = new ListNode(4);
        list5.next = list6;
        list6.next = list7;
        list7.next = list8;
        ListNode listNode = mergeTwoLists(list1, list5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
