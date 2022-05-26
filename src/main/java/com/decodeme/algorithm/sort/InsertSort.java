package com.decodeme.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.decodeme.util.SwapUtil;

/**
 * insert sort algorithm
 *
 * @date 2022-05-26
 */
public class InsertSort {

  public static void main(String[] args) {
    // 初始化一个数组
    int[] nums = new int[] {4, 9, 2, 4, 6, 1, 8, 0};
    // 输出一下数组
    System.out.println(JSON.toJSONString(nums));
    // 核心思想是:遍历数组,默认i前面的数据都是有序的;通过倒序遍历i(包含)前面的n个数据,nums[i]<nums[i-1]就将其交换位置;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j > 0; j--) {
        // 如果j比j-1小,j应该挪到前面
        if (nums[j] < nums[j - 1]) {
          // 交换
          SwapUtil.swap(nums, j, j - 1);
        }
      }
    }
    // 输入排序后的结果
    System.out.println(JSON.toJSONString(nums));
  }
}
