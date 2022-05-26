package com.decodeme.util;

import java.util.jar.JarEntry;

public class SwapUtil {

  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
