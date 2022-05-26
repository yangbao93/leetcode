package com.decodeme.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.decodeme.util.SwapUtil;

/**
 * 快速排序
 *
 * @date
 */
public class QuickSort {

  public static int[] quickSort(int[] nums, int l, int r) {
    int start = l;
    int end = r;
    int tmpNum = nums[start];
    while (start < end) {
      // 如果start小于end,对应的值也小于对比值,则start++,直到找到一个比对比值大的
      if ((start < end) && nums[start] < tmpNum) {
        start++;
      }
      // 如果end大于start,对应的值大于对比值,则end--,直到找到一个比对比值小的
      if ((start < end) && nums[end] > tmpNum) {
        end--;
      }
      if ((start < end) && (nums[start] == nums[end])) {
        start++;
      } else {
        SwapUtil.swap(nums, start, end);
      }
    }
    if (l - 1 > start) {
      nums = quickSort(nums, start, l - 1);
    }
    if (r + 1 < end) {
      nums = quickSort(nums, r + 1, end);
    }

    return nums;
  }

  public static void main(String[] args) {
    // 初始化一个数组
    int[] nums = new int[] {4, 9, 2, 4, 6, 1, 8, 0};
    // 输出一下数组
    System.out.println(JSON.toJSONString(nums));
    // 排序
    quickSort(nums, 0, nums.length - 1);
    // 输出排序后的数组
    System.out.println(JSON.toJSONString(nums));
  }
}
