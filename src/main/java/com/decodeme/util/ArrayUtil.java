package com.decodeme.util;

import org.springframework.util.StringUtils;

public class ArrayUtil {

  /**
   * 从string中快速构造int数组
   *
   * @param numStr string
   * @return 数组
   */
  public static int[] toArrays(String numStr) {
    if (StringUtils.isEmpty(numStr)) {
      return null;
    }
    String[] split = numStr.split(",");
    int[] nums = new int[split.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(split[i]);
    }
    return nums;
  }

  /**
   * 利用可变长度参数构造int数组
   *
   * @param params 参数
   * @return 数组
   */
  public static int[] toArrays(int... params) {
    return params;
  }
}
