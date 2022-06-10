package com.decodeme.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.decodeme.util.SwapUtil;

/** 堆排序 */
public class HeadSort {
  private static int len;

  public static int[] headSort(int[] nums) {
    len = nums.length;
    if (len < 1) {
      return nums;
    }
    // 构建一个最大堆
    buildMaxHead(nums);
    while (len > 0) {
      SwapUtil.swap(nums, 0, len - 1);
      len--;
      adjustHead(nums, 0);
    }
    return nums;
  }

  private static void buildMaxHead(int[] nums) {
    // 从最后一个非叶子节点开始向上构建最大堆
    for (int i = (len / 2 - 1); i >= 0; i--) {
      adjustHead(nums, i);
    }
    System.out.println("构造完成最大堆");
    System.out.println(JSON.toJSONString(nums));
  }

  private static void adjustHead(int[] nums, int i) {
    int maxIdx = i;
    int left = 2 * i + 1;
    int right = 2 * (i + 1);
    // 如果有左子树,且左子树大于父节点,则将最大指针指向左子树
    if (left < len && nums[left] > nums[maxIdx]) {
      maxIdx = left;
    }
    // 如果有右子树,且右子树大于父节点且大于左子树,则将最大指针指向右子树
    if (right < len && nums[right] > nums[maxIdx] && nums[right] > nums[left]) {
      maxIdx = right;
    }
    // 如果父节点不是最大值,则将父节点与最大值交换,并且递归调整与父节点交换的位置
    if (maxIdx != i) {
      SwapUtil.swap(nums, maxIdx, i);
      System.out.println(JSON.toJSONString(nums));
      adjustHead(nums, maxIdx);
    }
  }
}
