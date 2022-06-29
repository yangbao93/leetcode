package com.decodeme.leetcode.answer;

import com.decodeme.util.ArrayUtil;

/** 只出现一次的数字 */
public class SingleNumber {

  public void singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result = result ^ nums[i];
    }
    System.out.println(result + " 只出现了一次");
  }

  public static void main(String[] args) {
    int[] nums = ArrayUtil.toArrays(1, 1, 2, 2, 3, 4, 4);
    new SingleNumber().singleNumber(nums);
  }
}
