package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SubstringWithConcatenationOfAllWords
 * @Description NO.30 与所有单词相关联的字串
 * @Author
 * @Date 2018/12/21 下午4:48
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * 1.利用words所有单词等长的点，计算出每次要截取的str是多长length；
     * 2.截取的str，按照每个单词的长度，分成String[]
     * 3.将words转换成map，key存放单词，value存放key出现的次数（防止在main函数中出现的情况）
     * 4.for循环s，每次截取length长度的str，并转换成，list，每次增加length的长度
     * 5.for循环截取字符str转换的list，如果再map中出现，就将次数减一
     * 6.最后重新生成map
     */

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s == "") {
            return result;
        }

        if (words == null || words.length == 0) {
            return result;
        }
        int size = words[0].length();
        int totalSize = words.length * size;
        Map<String, Integer> wordsMap = wordsToMap(words);
        for (int i = 0; i < s.length(); i++) {
            int right = i + totalSize;
            if (right > s.length()) {
                break;
            }
            String substring = s.substring(i, right);
            List<String> subList = stringToList(substring, size);
            boolean flag = true;
            for (String key : subList) {
                if (wordsMap.containsKey(key)) {
                    Integer count = wordsMap.get(key);
                    if (count > 0) {
                        wordsMap.put(key, count - 1);
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            int count = 0;
            for (Integer value : wordsMap.values()) {
                count = count + value;
            }
            if (flag && (count == 0)) {
                result.add(i);
            }
            wordsMap = wordsToMap(words);
        }

        return result;
    }

    private List<String> stringToList(String substring, int size) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < substring.length(); ) {
            String temp = substring.substring(i, i + size);
            result.add(temp);
            i = i + size;
        }
        return result;
    }

    private Map<String, Integer> wordsToMap(String[] words) {
        Map<String, Integer> maps = new HashMap<>(words.length);
        for (String word : words) {
            if (maps.containsKey(word)) {
                Integer integer = maps.get(word);
                maps.put(word, integer + 1);
            } else {

                maps.put(word, 1);
            }
        }
        return maps;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords ob = new SubstringWithConcatenationOfAllWords();
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word", "good", "best", "good"};
        List<Integer> list = ob.findSubstring(s, words);
        System.out.println(list.toString());
    }
}
