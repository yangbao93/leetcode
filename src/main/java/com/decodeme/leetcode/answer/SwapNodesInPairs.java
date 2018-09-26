package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.List;

import com.decodeme.leetcode.entity.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author yb
 */
public class SwapNodesInPairs {

    //    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    //
    //    示例:
    //
    //    给定 1->2->3->4, 你应该返回 2->1->4->3.
    //    说明:
    //
    //    你的算法只能使用常数的额外空间。
    //    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }
        List<Integer> valueList = new ArrayList<>();
        // 链表的每个值都取出来
        while (head != null) {
            valueList.add(head.val);
            head = head.next;
        }
        // 进行两两交换
        for (int i = 0; i < valueList.size(); i++) {
            if ((i + 1) % 2 == 0) {
                int temp = valueList.get(i);
                valueList.set(i, valueList.get(i - 1));
                valueList.set(i - 1, temp);
            }
        }
        // 组装成返回结果
        ListNode result = new ListNode(valueList.get(valueList.size() - 1));
        for (int i = valueList.size() - 2; i >= 0; i--) {
            ListNode temp = new ListNode(valueList.get(i));
            temp.next = result;
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode temp1 = new ListNode(1);
        ListNode temp2 = new ListNode(2);
        ListNode temp3 = new ListNode(3);
        ListNode temp4 = new ListNode(4);
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        SwapNodesInPairs sn = new SwapNodesInPairs();
        ListNode listNode = sn.swapPairs(temp1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
