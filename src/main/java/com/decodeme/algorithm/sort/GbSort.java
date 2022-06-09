package com.decodeme.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.decodeme.util.ArrayUtil;

import java.util.Arrays;

public class GbSort {

    /**
     * 归并排序
     *
     * @param nums 传入数组
     * @return 排序结果
     */
    public int[] gbSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(gbSort(left), gbSort(right));
    }

    /**
     * 合并方法
     *
     * @param left
     * @param right
     * @return
     */
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int idx = 0, i = 0, j = 0; idx < result.length; idx++) {
            if (i >= left.length) {
                result[idx] = right[j++];
            } else if (j >= right.length) {
                result[idx] = left[i++];
            } else if (left[i] > right[j]) {
                result[idx] = right[j++];
            } else {
                result[idx] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GbSort sort = new GbSort();
        int[] ints = ArrayUtil.toArrays(1, 3, 2, 7, 6, 4);
        System.out.println(JSON.toJSONString(sort.gbSort(ints)));

    }
}
