package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.decodeme.leetcode.entity.ListNode;

/**
 * 合并K个有序链表，参考合并两个链表
 * <p>
 * 参考：https://juejin.im/post/5ad30f286fb9a028d5678e4a
 * 其中方法三思路很有意思：将所有的数字取出来，放在一个list，然后对这个list进行排序，再转成链表
 */
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);
        ListNode node = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (node == null) {
                node = new ListNode(list.get(i));
            } else {
                ListNode temp = new ListNode(list.get(i));
                temp.next = node;
                node = temp;
            }
        }
        return node;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode result = null;
        lists = removeNull(lists);
        if (lists == null) {
            return result;
        }
        while (lists != null) {
            int i = 0, j = lists.length - 1, min = Integer.MAX_VALUE, key = 0;
            while (i <= j) {
                boolean flag = lists[i].val <= lists[j].val;
                int temp = flag ? lists[i].val : lists[j].val;
                if (temp <= min) {
                    min = temp;
                    key = flag ? i : j;
                    if (flag) {
                        i++;
                    } else {
                        j--;
                    }
                } else {
                    i++;
                    j--;
                }
            }
            result = addVal(result, min);
            lists[key] = lists[key].next;
            lists = removeNull(lists);
        }
        return result;
    }

    private static ListNode[] removeNull(ListNode[] lists) {
        List<ListNode> tempList = new ArrayList<>();
        for (ListNode list : lists) {
            if (lists.length != 0 && list != null) {
                tempList.add(list);
            }
        }
        if (tempList == null || tempList.size() == 0) {
            return null;
        }
        ListNode[] temp = new ListNode[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            temp[i] = tempList.get(i);
        }
        return temp;
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
        // [[1,4,5],[1,3,4],[2,6]]
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        ListNode list5 = new ListNode(1);
        ListNode list6 = new ListNode(3);
        ListNode list7 = new ListNode(4);
        list5.next = list6;
        list6.next = list7;
        ListNode list8 = new ListNode(2);
        ListNode list9 = new ListNode(6);
        list8.next = list9;
        ListNode[] lists = new ListNode[] {list1, list5, list8};
        ListNode listNode = mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
