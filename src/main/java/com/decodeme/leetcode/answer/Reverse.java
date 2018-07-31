package com.decodeme.leetcode.answer;

import java.io.UnsupportedEncodingException;

/**
 * 翻转整数
 */
public class Reverse {
    //    给定一个 32 位有符号整数，将整数中的数字进行反转。
    //
    //    示例 1:
    //
    //    输入: 123
    //    输出: 321
    //    示例 2:
    //
    //    输入: -123
    //    输出: -321
    //    示例 3:
    //
    //    输入: 120
    //    输出: 21
    //    注意:
    //
    //    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，
    // 如果反转后的整数溢出，则返回 0。

    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }
        String xStr = null;
        boolean flag = true;
        if (x > 0) {
            xStr = String.valueOf(x);
        } else {
            xStr = String.valueOf(x).substring(1);
            flag = false;
        }

        int i = 0;
        int j = xStr.length() - 1;
        char[] chars = new char[xStr.length()];
        while (i <= j) {
            int size = j - i;
            chars[i] = xStr.charAt(size);
            chars[size] = xStr.charAt(i);
            i++;
        }
        String str = new String(chars);
        if (!flag) {
            str = "-" + str;
        }
        Long aLong = Long.valueOf(str);
        if (aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE) {
            return 0;
        }
        return Math.toIntExact(aLong);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Reverse rv = new Reverse();
        int reverse = rv.reverse(90100);
        System.out.println(reverse);
    }
}
