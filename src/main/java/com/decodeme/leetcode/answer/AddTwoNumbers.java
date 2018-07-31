package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.List;

import com.decodeme.leetcode.entity.ListNode;

public class AddTwoNumbers {


//    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//    输出：7 -> 0 -> 8
//    原因：342 + 465 = 807
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> l1List = new ArrayList<>();
        List<Integer> l2List = new ArrayList<>();

        while (l1 != null){
            l1List.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2List.add(l2.val);
            l2 = l2.next;
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = l1List.size()-1; i >=0 ; i--) {
            sb1.append(l1List.get(i));
        }
        System.out.println(sb1.toString());
        StringBuilder sb2 = new StringBuilder();
        for (int i = l2List.size()-1; i >=0 ; i--) {
            sb2.append(l2List.get(i));
        }
        System.out.println(sb2.toString());
        Integer sum = Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());
        String sumStr = String.valueOf(sum);
        char[] toCharArray = sumStr.toCharArray();

        ListNode result = null;
        for (int i = toCharArray.length-1; i < toCharArray.length; i++) {
            ListNode temp = new ListNode(toCharArray[i]);
            temp.next = result;
            result = temp;
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(1);
//        ListNode l11 = new ListNode(2);
//        ListNode l12 = new ListNode(4);
//        ListNode l13 = new ListNode(3);
//        l12.next = l13;
//        l11.next = l12;
//        ListNode l21 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l22.next = l23;
//        l21.next = l22;
//        ListNode listNode = AddTwoNumbers.addTwoNumbers(l11, l21);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }

    }

//    List<Integer> tempList1 = new ArrayList<Integer>();
//        while(l1.hasNext){
//        tempList1.add(l1.next());
//        l1 = l1.next();
//    }
//    StringBuilder sb1 = new StringBuilder();
//        for(int i = tempList1.size()-1;i>=0;i--){
//        sb1.append(tempList1(i));
//    }
//    List<Integer> tempList2 = new ArrayList<Integer>();
//        while(l2.hasNext){
//        tempList2.add(l2.next());
//        l2 = l2.next();
//    }
//    StringBuilder sb2 = new StringBuilder();
//        for(int i = tempList2.size()-1;i>=0;i--){
//        sb2.append(tempList1(2));
//    }
//    Integer int1 = Integer.valueOf(sb1.toString);
//    Integer int2 = Integer.valueOf(sb2.toString);
//    int sum = int1 + int2;
//    String sumStr = String.valueOf(sum);
}
