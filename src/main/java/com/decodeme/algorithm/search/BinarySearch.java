package com.decodeme.algorithm.search;

import com.decodeme.util.ArrayUtil;

/** 二分查找法 */
public class BinarySearch {

  public void binarySearch(int[] nums, int target) {
    // 需要nums是有序的
    if (nums == null || nums.length == 0) {
      return;
    }
    // 进行二分查找
    int idx = search(nums, target, nums.length / 2);
    System.out.println("找到对应的target值,在数组的位置为:" + idx);
  }

  /**
   * 二分查找
   *
   * @param nums 数组
   * @param target 目标
   * @param idx 查找点idx
   * @return 结果
   */
  private int search(int[] nums, int target, int idx) {
    // 如果结果点满足查找的数据,则返回
    if (nums[idx] == target) {
      return idx;
    }
    // 如果等于数组长度或小于0,即退出循环,表示没有找到
    if (idx >= nums.length - 1 || idx <= 0) {
      return -1;
    }
    if (nums[idx] > target) {
      // 如果数据小于中间值,查找左边
      return search(nums, target, (0 + idx) / 2);
    } else {
      // 如果数据大于中间值,查找右边
      return search(nums, target, (nums.length + idx) / 2);
    }
  }

  public static void main(String[] args) {
    int[] nums = ArrayUtil.toArrays(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    BinarySearch search = new BinarySearch();
    search.binarySearch(nums, 2);
    search.binarySearch(nums, 1);
    search.binarySearch(nums, 10);
    search.binarySearch(nums, 100);
    search.binarySearch(nums, -1);
  }
}
