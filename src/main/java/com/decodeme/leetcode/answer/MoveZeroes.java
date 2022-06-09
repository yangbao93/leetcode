package com.decodeme.leetcode.answer;

public class MoveZeroes {

  public void moveZeroes(int[] nums) {
    // 是否是空数组
    if (nums == null) {
      return;
    }
    // 双指针i与j,初始的时候都指向数组第一个值;
    // 通过i遍历数组,如果不是0,就将它的值赋值给nums[j],并将j++;
    // 遍历完第一次后,将j后面的数组值全部置为0即可
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j++] = nums[i];
      }
    }
    // 将j后面的值全部置为0
    for (int i = j; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
