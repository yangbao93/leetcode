package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.decodeme.leetcode.entity.ListNode;
import com.sun.corba.se.spi.ior.iiop.IIOPFactories;

public class ReverseNodesInKGroup {
    //    给定这个链表：1->2->3->4->5
    //
    //    当 k = 2 时，应当返回: 2->1->4->3->5
    //
    //    当 k = 3 时，应当返回: 3->2->1->4->5
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<Integer> valueList = new ArrayList<>();
        // 链表的每个值都取出来
        while (head != null) {
            valueList.add(head.val);
            head = head.next;
        }
        List<List<Integer>> splitList = this.splitList(valueList, k);
        List<Integer> valueList2 = new ArrayList<>();
        for (int i = 0; i < splitList.size(); i++) {
            List<Integer> integerList = splitList.get(i);
            if (integerList.size() == k) {
                Collections.reverse(integerList);
            }
            valueList2.addAll(integerList);
        }
        // 组装成返回结果
        ListNode result = new ListNode(valueList2.get(valueList2.size() - 1));
        for (int i = valueList2.size() - 2; i >= 0; i--) {
            ListNode temp = new ListNode(valueList2.get(i));
            temp.next = result;
            result = temp;
        }
        return result;
    }

    private List<List<Integer>> splitList(List<Integer> list, int groupSize) {
        int length = list.size();
        // 计算可以分成多少组
        int num = (length + groupSize - 1) / groupSize;
        List<List<Integer>> newList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = (i + 1) * groupSize < length ? (i + 1) * groupSize : length;
            newList.add(list.subList(fromIndex, toIndex));
        }
        return newList;
    }

    public static void main(String[] args) {
        ListNode temp1 = new ListNode(1);
        ListNode temp2 = new ListNode(2);
        ListNode temp3 = new ListNode(3);
        ListNode temp4 = new ListNode(4);
        ListNode temp5 = new ListNode(5);
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
        ListNode listNode = rn.reverseKGroup(temp1, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
