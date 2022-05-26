package com.decodeme.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.decodeme.util.SwapUtil;

/**
 * 希尔排序
 *
 * @date
 */
public class ShellSort {

  public static void shellSort(int[] nums) {
    int gap = nums.length;
    while (true) {
      // 设置一个gap值
      gap /= 2;
      for (int i = 0; i < gap; i++) {
        for (int j = i + gap; j < nums.length; j += gap) {
          int k = j - gap;
          while (k >= 0 && nums[k] > nums[k + gap]) {
            SwapUtil.swap(nums, k, k + gap);
            k -= gap;
          }
        }
      }
      if (gap == 1) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    // 初始化一个数组
    int[] nums = new int[] {4, 9, 2, 4, 6, 1, 8, 0};
    // 输出一下数组
    System.out.println(JSON.toJSONString(nums));
    // 排序
    shellSort(nums);
    // 输出排序后的数组
    System.out.println(JSON.toJSONString(nums));
  }
}
