package com.decodeme.leetcode.answer;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

/**
 * 字符串转整数 (atoi)
 */
public class StringToInteger {
    //    实现 atoi，将字符串转为整数。
    //
    // 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
    //    字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
    //    当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
    //    若函数不能执行有效的转换，返回 0。
    //    说明：
    //
    //    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
    //
    //
    //    示例 1:
    //    输入: "42"
    //    输出: 42
    //
    //    示例 2:
    //    输入: "   -42"
    //    输出: -42
    //    解释: 第一个非空白字符为 '-', 它是一个负号。
    //    我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
    //
    //    示例 3:
    //    输入: "4193 with words"
    //    输出: 4193
    //    解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
    //
    //    示例 4:
    //    输入: "words and 987"
    //    输出: 0
    //    解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
    //    因此无法执行有效的转换。
    //    //
    //    示例 5:
    //    输入: "-91283472332"
    //    输出: -2147483648
    //    解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
    //    因此返回 INT_MIN (−231) 。
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String trimStr = str.trim();
        if ("".equals(trimStr)) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        char zero = "0".charAt(0);
        char nine = "9".charAt(0);
        char line = "-".charAt(0);
        char plus = "+".charAt(0);
        boolean numStartFlag = false;
        boolean symbolFlag = false;
        // 只有一个字符，且不为数字的情况
        if (str.length() == 1 && (trimStr.charAt(0) < zero || trimStr.charAt(0) > nine)) {
            return 0;
        }
        for (int i = 0; i < trimStr.length(); i++) {
            char tempChar = trimStr.charAt(i);
            boolean isNumberFlag = tempChar >= zero && tempChar <= nine;
            if (i == 0 && !(isNumberFlag || tempChar == line || tempChar == plus)) {
                return 0;
            }
            if (i == 0 && tempChar == line) {
                sb.append(tempChar);
                symbolFlag = true;
                continue;
            }
            if (i == 0 && tempChar == plus) {
                symbolFlag = true;
                continue;
            }
            if (isNumberFlag) {
                sb.append(tempChar);
                numStartFlag = true;
                continue;
            }
            if (!numStartFlag) {
                if (symbolFlag) {
                    return 0;
                }
                continue;
            }
            break;
        }
        if (sb.length() == 1 && sb.charAt(0) == line) {
            return 0;
        }
        if (sb.length() == 0) {
            return 0;
        }
        String dealStartWithZero = null;
        if (sb.toString().startsWith("-")) {
            dealStartWithZero = "-" + this.dealStartWithZero(sb.toString().substring(1));
        } else {
            dealStartWithZero = this.dealStartWithZero(sb.toString());
        }
        return this.compareTo(dealStartWithZero);
    }

    private String dealStartWithZero(String str) {
        boolean flag = true;
        while (flag) {
            if (str.startsWith("0")) {
                str = str.substring(1);
                continue;
            }
            flag = false;
        }

        return str;
    }

    private Integer compareTo(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1 && (str.charAt(0) < "0".charAt(0) || str.charAt(0) > "9".charAt(0))) {
            return 0;
        }
        String maxStr = String.valueOf(Integer.MAX_VALUE);
        String minStr = String.valueOf(Integer.MIN_VALUE);
        byte[] strBytes = str.getBytes();
        if (minStr.length() == str.length() && str.startsWith("-")) {
            byte[] minStrBytes = minStr.getBytes();
            for (int i = 0; i < strBytes.length; i++) {
                if (strBytes[i] < minStrBytes[i]) {
                    return Integer.parseInt(str);
                }
                if (strBytes[i] > minStrBytes[i]) {
                    break;
                }
            }
            return Integer.MIN_VALUE;
        }
        if (maxStr.length() == str.length() && !str.startsWith("-")) {
            byte[] maxStrBytes = maxStr.getBytes();
            for (int i = 0; i < strBytes.length; i++) {
                if (strBytes[i] < maxStrBytes[i]) {
                    return Integer.parseInt(str);
                }
                if (strBytes[i] > maxStrBytes[i]){
                    break;
                }

            }
            return Integer.MAX_VALUE;
        }

        if (maxStr.length() > str.length() || minStr.length() > str.length()) {
            return Integer.parseInt(str);
        }
        if (!str.startsWith("-") && maxStr.length() < str.length()) {
            return Integer.MAX_VALUE;
        }
        if (str.startsWith("-") && minStr.length() < str.length()) {
            return Integer.MIN_VALUE;
        }
        return 0;
    }

    public static void main(String[] args) {
        StringToInteger si = new StringToInteger();
        System.out.println(si.myAtoi("2147483646"));
    }
}
