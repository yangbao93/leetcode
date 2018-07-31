package com.decodeme.leetcode;

import sun.jvm.hotspot.gc_implementation.parallelScavenge.PSYoungGen;

/**
 * Z字形变换
 */
public class Solution {

    //        将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
    //
    //        P   A   H   N
    //        A P L S I I G
    //        Y   I   R
    //        之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
    //
    //        实现一个将字符串进行指定行数变换的函数:
    //
    //        string convert(string s, int numRows);
    //        示例 1:
    //
    //        输入: s = "PAYPALISHIRING", numRows = 3
    //        输出: "PAHNAPLSIIGYIR"
    //        示例 2:
    //
    //        输入: s = "PAYPALISHIRING", numRows = 4
    //        输出: "PINALSIGYAHRPI"
    //        解释:
    //
    //        P     I    N
    //        A   L S  I G
    //        Y A   H R
    //        P     I
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        // 字符间隔
        int temp = 2*numRows -2;
        for (int i = 0; i < numRows; i++) {
            int row = i;
            if (i == 0){
                // 处理第一行
                while (row < s.length()) {
                    sb.append(s.charAt(row));
                    row += temp;
                }
            }else if (i == numRows-1){
                // 处理尾行
                while (row < s.length()) {
                    sb.append(s.charAt(row));
                    row += temp;
                }
            }else {
                // 处理中间行
                // 中间行的中间字符间隔
                int intervalSize = temp - 2*i;
                while (row < s.length()) {
                    sb.append(s.charAt(row));
                    int tempSize = row + intervalSize;
                    if (tempSize < s.length()) {
                        sb.append(s.charAt(tempSize));
                    }
                    row += temp;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String paypalishiring = sl.convert("ABC", 3);
        System.out.println(paypalishiring);
    }
}

