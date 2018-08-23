package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成，解法思路可以使用dfs
 */
public class GenerateParentheses {
    //    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
    //
    //    例如，给出 n = 3，生成结果为：
    //
    //            [
    //            "((()))",
    //            "(()())",
    //            "(())()",
    //            "()(())",
    //            "()()()"
    //            ]
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;
    }

    private void generate(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        generate(left - 1, right, out + "(", res);
        generate(left, right - 1, out + ")", res);
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> stringList = gp.generateParenthesis(4);
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
