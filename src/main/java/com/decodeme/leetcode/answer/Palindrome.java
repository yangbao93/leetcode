package com.decodeme.leetcode.answer;

import java.time.temporal.Temporal;

/**
 * 回文数
 */
public class Palindrome {
    //    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //
    //    示例 1:
    //
    //    输入: 121
    //    输出: true
    //    示例 2:
    //
    //    输入: -121
    //    输出: false
    //    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    //    示例 3:
    //
    //    输入: 10
    //    输出: false
    //    解释: 从右向左读, 为 01 。因此它不是一个回文数。
    //    进阶:
    //
    //    你能不将整数转为字符串来解决这个问题吗？

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0) {
            return false;
        }
        int newX = 0;
        int copyX = x;
        while (copyX > 0) {
            int temp = copyX % 10;
            copyX = (copyX - temp) / 10;
            newX = newX * 10 + temp;
        }
        if (newX == x) {
            return true;
        }
        return false;
    }

    /**
     * 使用字符串解决该问题
     *
     * @param x
     *
     * @return
     */
    public boolean isPalindromeOld(int x) {
        if (x < 0) {
            return false;
        }
        String xStr = String.valueOf(x);
        int j = xStr.length() - 1;
        int i = 0;
        while (i <= j) {
            if (xStr.charAt(i) != xStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome pl = new Palindrome();
        System.out.println(pl.isPalindromeOld(1231242));
        System.out.println(pl.isPalindrome(1231242));
        System.out.println(1231241 % 10);
    }
}
