package com.decodeme.leetcode.answer;

import java.util.Calendar;

/**
 * 整数转罗马数字
 *
 * @author yb
 */
public class Integer2Roman {
    //    罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
    //
    //    字符          数值
    //    I             1
    //    V             5
    //    X             10
    //    L             50
    //    C             100
    //    D             500
    //    M             1000
    //    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    //
    //    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为
    // IX。这个特殊的规则只适用于以下六种情况：
    //
    //    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    //    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
    //    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    //    给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
    //
    //    示例 1:
    //
    //    输入: 3
    //    输出: "III"
    //    示例 2:
    //
    //    输入: 4
    //    输出: "IV"
    //    示例 3:
    //
    //    输入: 9
    //    输出: "IX"
    //    示例 4:
    //
    //    输入: 58
    //    输出: "LVIII"
    //    解释: C = 100, L = 50, XXX = 30, III = 3.
    //    示例 5:
    //
    //    输入: 1994
    //    输出: "MCMXCIV"
    //    解释: M = 1000, CM = 900, XC = 90, IV = 4.
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 1 || num > 3999) {
            return null;
        }
        // 千位
        int temp = num / 1000;
        if (temp != 0) {
            for (int i = 0; i < temp; i++) {
                sb.append("M");
                num -= 1000;
            }
        }
        // 百位
        int temp2 = num / 100;
        if (temp2 != 0) {
            if (temp2 < 4) {
                for (int i = 0; i < temp2; i++) {
                    sb.append("C");
                    num -= 100;
                }
            } else if (temp2 == 4) {
                sb.append("CD");
                num -= 400;
            } else if (temp2 < 9) {
                sb.append("D");
                num -= 500;
                for (int i = 0; i < temp2 - 5; i++) {
                    sb.append("C");
                    num -= 100;
                }
            } else {
                sb.append("CM");
                num -= 900;
            }
        }
        // 十位
        int temp3 = num / 10;
        if (temp3 != 0) {
            if (temp3 < 4) {
                for (int i = 0; i < temp3; i++) {
                    sb.append("X");
                    num -= 10;
                }
            } else if (temp3 == 4) {
                sb.append("XL");
                num -= 40;
            } else if (temp3 < 9) {
                sb.append("L");
                num -= 50;
                for (int i = 0; i < temp3 - 5; i++) {
                    sb.append("X");
                    num -= 10;
                }
            } else {
                sb.append("XC");
                num -= 90;
            }
        }
        // 个位
        if (num < 4) {
            for (int i = 0; i < num; i++) {
                sb.append("I");
            }
        } else if (num == 4) {
            sb.append("IV");
        } else if (num < 9) {
            sb.append("V");
            for (int i = 0; i < num - 5; i++) {
                sb.append("I");
            }
        } else {
            sb.append("IX");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer2Roman roman = new Integer2Roman();
        System.out.println(roman.intToRoman(2000));
    }
}
