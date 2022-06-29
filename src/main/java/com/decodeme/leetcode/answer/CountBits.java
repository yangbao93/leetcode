package com.decodeme.leetcode.answer;

import com.alibaba.fastjson.JSON;

public class CountBits {
  /**
   * 利用x=x&(x-1)来进行计数
   *
   * @param target 目标数
   */
  public void countBits(int target) {
    int[] result = new int[target + 1];
    for (int i = 1; i <= target; i++) {
      result[i] = result[i & (i - 1)] + 1;
    }
    System.out.println(JSON.toJSONString(result));
  }

  /**
   * 利用奇偶性来进行计数
   *
   * @param target 目标数
   */
  public void countBits2(int target) {
    int[] result = new int[target + 1];
    result[0] = 0;
    for (int i = 1; i <= target; i++) {
      result[i] = ((i & 1) == 1) ? result[i - 1] + 1 : result[i >> 1];
    }
    System.out.println(JSON.toJSONString(result));
  }

  public static void main(String[] args) {
    new CountBits().countBits(5);
    new CountBits().countBits2(5);
  }
}
