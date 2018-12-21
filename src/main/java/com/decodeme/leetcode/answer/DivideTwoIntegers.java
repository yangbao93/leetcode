package com.decodeme.leetcode.answer;

public class DivideTwoIntegers {

    //    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    //
    //    返回被除数 dividend 除以除数 divisor 得到的商。
    //
    //    示例 1:
    //
    //    输入: dividend = 10, divisor = 3
    //    输出: 3
    //    示例 2:
    //
    //    输入: dividend = 7, divisor = -3
    //    输出: -2

    //    说明:
    //
    //    被除数和除数均为 32 位有符号整数。
    //    除数不为 0。
    //    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        long d = 0;
        long dvd = Math.abs(Long.valueOf(dividend));
        long dvs = Math.abs(Long.valueOf(divisor));
        while (dvd >= dvs) {
            long temp = dvs;
            long divide = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                divide <<= 1;
            }
            dvd -= temp;//改变被除数的大小
            d += divide;
        }
        System.out.println(d);
        return (int) d;
    }

    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        long result = 0;
        long dvd = Math.abs(Long.valueOf(dividend));
        long dvs = Math.abs(Long.valueOf(divisor));
        while (dvd >= dvs) {
            dvd = dvd - dvs;
            result++;
        }
        System.out.println(result);
        return (int) (flag ? result : -result);
    }

    public static void main(String[] args) {
        DivideTwoIntegers dt = new DivideTwoIntegers();
        dt.divide(3000, 70);
        dt.divide2(-2147483648, 1);
    }
}
