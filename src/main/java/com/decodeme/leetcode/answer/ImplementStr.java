package com.decodeme.leetcode.answer;

public class ImplementStr {

    //    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
    //
    //    示例 1:
    //
    //    输入: haystack = "hello", needle = "ll"
    //    输出: 2
    //    示例 2:
    //
    //    输入: haystack = "aaaaa", needle = "bba"
    //    输出: -1
    public int strStr(String haystack, String needle) {
        // "".equals(needle)使用成"" == needle 时候，会出现无法通过的情况
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        int len = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if ((i + len - 1) >= haystack.length()) {
                    return -1;
                }
                boolean flag = true;
                for (int j = 0; j < len; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStr is = new ImplementStr();
        int str = is.strStr("a", "");
        System.out.println(str);
    }
}
