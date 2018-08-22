package com.decodeme.leetcode.answer;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的括号,解法不优美，建议使用stack进行解答
 * 参考https://www.jianshu.com/p/87ec67e4b611
 */
public class ValidParentheses {
    //    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //
    //    有效字符串需满足：
    //
    //    左括号必须用相同类型的右括号闭合。
    //    左括号必须以正确的顺序闭合。
    //    注意空字符串可被认为是有效字符串。
    //
    //    示例 1:
    //
    //    输入: "()"
    //    输出: true
    //    示例 2:
    //
    //    输入: "()[]{}"
    //    输出: true
    //    示例 3:
    //
    //    输入: "(]"
    //    输出: false
    //    示例 4:
    //
    //    输入: "([)]"
    //    输出: false
    //    示例 5:
    //
    //    输入: "{[]}"
    //    输出: true
    public static boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Integer, Character> charMap = new HashMap<Integer, Character>();
        for (int i = 0; i < s.length(); i++) {
            charMap.put(i, s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            Character left = charMap.get(i);
            if (left == null) {
                continue;
            }
            for (int j = i+1; j < s.length(); j++) {

                Character right = charMap.get(j);
                if (right == null) {
                    continue;
                }
                if (check(left, right) && (j - i + 1) % 2 == 0) {
                    charMap.remove(i);
                    charMap.remove(j);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private static boolean check(Character left, Character right) {
        char smallLeft = '(';
        char smallRight = ')';
        char middleLeft = '[';
        char middleRight = ']';
        char bigLeft = '{';
        char bigRight = '}';
        if (left == smallLeft) {
            return right == smallRight;
        } else if (left == middleLeft) {
            return right == middleRight;
        } else if (left == bigLeft) {
            return right == bigRight;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

}
