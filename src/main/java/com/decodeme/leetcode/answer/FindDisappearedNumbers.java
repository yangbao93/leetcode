package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null) {
      return null;
    }
    for (int i = 0; i < nums.length; i++) {
      int newInx = nums[i];
      if (0 > newInx && nums.length > newInx) {
        nums[newInx-1] = nums[i] - nums.length;
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        continue;
      }
      result.add(i);
    }
    return result;
  }
}
