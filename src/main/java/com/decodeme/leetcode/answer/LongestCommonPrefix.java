package com.decodeme.leetcode.answer;

import java.util.Arrays;

/**
 * 最长公共前缀
 *
 * @author yb
 */
public class LongestCommonPrefix {

    //    编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //    如果不存在公共前缀，返回空字符串 ""。
    //
    //    示例 1:
    //
    //    输入: ["flower","flow","flight"]
    //    输出: "fl"
    //    示例 2:
    //
    //    输入: ["dog","racecar","car"]
    //    输出: ""
    //    解释: 输入不存在公共前缀。
    //    说明:
    //
    //    所有输入只包含小写字母 a-z 。
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        int pos = 0;
        boolean flag = true;
        boolean notNullStrs = strs != null && strs.length != 0;
        while (flag && notNullStrs) {
            Character key = null;
            for (String str : strs) {
                if (str.length() == 0) {
                    flag = false;
                    break;
                }
                if (pos >= str.length()) {
                    flag = false;
                    break;
                }
                key = strs[0].charAt(pos);
                if (key != str.charAt(pos)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            sb.append(strs[0].charAt(pos));
            pos++;
        }

        return sb.toString();
    }

    /**
     * 参考排名前列的同学的答案
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s) != 0) {
                s = s.substring(0, s.length() - 1);
                if (s.isEmpty()) {
                    return "";
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] str = new String[] {"a"};
        String prefix = longestCommonPrefix(str);
        System.out.println(prefix);
    }

}
