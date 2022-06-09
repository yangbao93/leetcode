package com.decodeme.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.decodeme.util.ArrayUtil;
import com.decodeme.util.SwapUtil;

/** 选择排序 */
public class SelectSort {

  public void selectSort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      // 暂定i为最小的
      int min = nums[i];
      int minIdx = i;
      for (int i1 = i; i1 < nums.length; i1++) {
        // 遍历剩余的数字,找到最小的那一个
        if (nums[i1] < min) {
          min = nums[i1];
          minIdx = i1;
        }
      }
      SwapUtil.swap(nums, i, minIdx);
    }
    System.out.println(JSON.toJSONString(nums));
  }

  public static void main(String[] args) {
    SelectSort sort = new SelectSort();
    int[] nums = ArrayUtil.toArrays(1, 4, 8, 6, 7, 2);
    System.out.println(JSON.toJSONString(nums));
    sort.selectSort(nums);
  }
}
