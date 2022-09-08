package com.decodeme.leetcode.answer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 56.合并区间
 */
public class VectorMerge {

    public int[][] merge(int[][] intervals) {
        // 部分异常判断
        if (intervals == null || intervals.length <= 0) {
            return null;
        }

        // 增加sort,防止出现第二个数组比第一个小的情况
        Stream<int[]> sorted = Arrays.stream(intervals).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> intervalsSort = sorted.collect(Collectors.toList());

        int tmpMin = intervalsSort.get(0)[0];
        int tmpMax = intervalsSort.get(0)[1];
        List<int[]> resultList = new ArrayList<>();

        for (int i = 1; i < intervalsSort.size(); i++) {
            // 如果当前int[]最小值 <= 前一个int[]的最大值，那么就需要重新设置tmpMax
            if (intervalsSort.get(i)[0] <= tmpMax) {
                tmpMax = tmpMax > intervalsSort.get(i)[1] ? tmpMax : intervalsSort.get(i)[1];
                tmpMin = tmpMin < intervalsSort.get(i)[0] ? tmpMin : intervalsSort.get(i)[0];
            } else {
                // 如果当前int[]最小值 > 前一个int[]的最大值，那么属于两个区间，不可以合并。
                // 此时需要把前一个区间设置好，并将tmpMin与tmpMax重置为当前区间的min与max
                int[] tmpArr = new int[]{tmpMin, tmpMax};
                resultList.add(tmpArr);
                // 重置tmpMin与tmpMax
                tmpMin = intervalsSort.get(i)[0];
                tmpMax = intervalsSort.get(i)[1];

            }
        }
        // 最后一个元素需要处理
        int[] tmpArr = new int[]{tmpMin, tmpMax};
        resultList.add(tmpArr);

        // resultList to resultArray
        int[][] resultArray = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        VectorMerge vectorMerge = new VectorMerge();
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] nums = new int[][]{{1, 4}, {0, 1}};
//        int [][] nums = new int[][]{{1,4},{0,0}};
        int[][] result = vectorMerge.merge(nums);
        System.out.println(JSON.toJSONString(result));
    }
}
