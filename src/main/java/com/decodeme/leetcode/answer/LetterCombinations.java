package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.decodeme.leetcode.entity.ListNode;

/**
 * 电话号码的字母组合
 *
 * @author yb
 */
public class LetterCombinations {
    //
    //    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    //
    //    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //
    //
    //
    //    示例:
    //
    //    输入："23"
    //    输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    //    说明:
    //    尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
    public List<String> letterCombinations(String digits) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp1 = new ArrayList<>();
        if (digits == null || digits == "") {
            return temp1;
        }
        int pos = 0;
        while (pos < digits.length()) {
            List<String> temp = new ArrayList<>();
            switch (digits.charAt(pos)) {
                case '2':
                    temp.add("a");
                    temp.add("b");
                    temp.add("c");
                    list.add(temp);
                    break;
                case '3':
                    temp.add("d");
                    temp.add("e");
                    temp.add("f");
                    list.add(temp);
                    break;
                case '4':
                    temp.add("g");
                    temp.add("h");
                    temp.add("i");
                    list.add(temp);
                    break;
                case '5':
                    temp.add("j");
                    temp.add("k");
                    temp.add("l");
                    list.add(temp);
                    break;
                case '6':
                    temp.add("m");
                    temp.add("n");
                    temp.add("o");
                    list.add(temp);
                    break;
                case '7':
                    temp.add("p");
                    temp.add("q");
                    temp.add("r");
                    temp.add("s");
                    list.add(temp);
                    break;
                case '8':
                    temp.add("t");
                    temp.add("u");
                    temp.add("v");
                    list.add(temp);
                    break;
                case '9':
                    temp.add("w");
                    temp.add("x");
                    temp.add("y");
                    temp.add("z");
                    list.add(temp);
                    break;
            }
            pos++;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        for (int i = 1; i < list.size(); i++) {
            List<String> stringList = this.addTwoList(list.get(0), list.get(i));
            list.set(0, stringList);
        }
        return list.get(0);
    }

    private List<String> addTwoList(List<String> str1, List<String> str2) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < str1.size(); i++) {
            for (int j = 0; j < str2.size(); j++) {
                String toString = new StringBuilder(str1.get(i)).append(str2.get(j)).toString();
                resultList.add(toString);
            }
        }
        return resultList;
    }

    private List<String> method2(String digits) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result = new LinkedList<>();//结果集
        if (digits.length() == 0) {
            return result;
        }
        Queue<StringBuilder> queue = new LinkedList<>();//队列
        queue.add(new StringBuilder());//先在队列中添加一个新的空字符串

        for (int i = 0; i < digits.length(); ++i) {//循环所有输入的数字
            int limitSize = queue.size();//记录每次出队列之前的元素的个数
            if (digits.charAt(i) == '0' || digits.charAt(i) == '1') {//如果数字是0或1,因为没有对应的字母，则跳过
                continue;
            }
            int tar = digits.charAt(i) - '0';
            int j = 0;//用于将queue中的元素依次出队列
            while (!queue.isEmpty() && j < limitSize) {//循环j将limitsize个元素依次出队列
                StringBuilder stringBuilder1 = queue.poll();//每次将队列头一个stringBuilder出队列
                for (char x : map.get(tar).toCharArray()) {//循环每一个数字对应的字母，依次加入到队列中
                    StringBuilder tmp = new StringBuilder(stringBuilder1);//获得每一个出对列的stringBuilder，并将后面的字母append到后面
                    tmp.append(x);
                    queue.add(tmp);//将stringBuilder加入到队列中
                }
                ++j;
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll().toString());//依次将队列中的字符串加入到结果集中
        }
        return result;
    }

    public List<String> letterCombinations3(String digits) {
        if (digits.length() == 0) {
            return null;
        }
        List<String> answer = new ArrayList<String>();

        //开始回溯
        zuhe(digits, 0, answer);
        return answer;
    }

    //定义每个数字对应的字符
    static String[] a = new String[] {"", "", "abc", "def",
            "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static StringBuffer sb = new StringBuffer();

    private static void zuhe(String digits, int n, List<String> answer) {
        if (n == digits.length()) {
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < a[digits.charAt(n) - '0'].length(); i++) {
            sb.append(a[digits.charAt(n) - '0'].charAt(i));
            zuhe(digits, n + 1, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        List<String> strings = lc.letterCombinations("");
        List<String> strings1 = lc.method2("");
        List<String> strings2 = lc.letterCombinations3("");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
