package com.decodeme.leetcode.answer;

public class HanMingDistance {

  public void hanMingDistance(int num1, int num2) {
    // 汉明距离就是两个数字转为二进制数字后,数字不同的个数
    // 此题可理解为:num1 异或 num2后求1的个数
    // 0100 ^ 0010 = 0110 ,利用公式x=x&(x-1)的方式,当这个结果不为0时distance++,等于0时退出
    int tmp = num1 ^ num2;
    int distance = 0;
    for (int i = tmp; i != 0; i = i & (i - 1)) {
      distance++;
    }
    System.out.println(String.format("%s与%s汉明距离为%s", num1, num2, distance));
  }

  public static void main(String[] args) {
    new HanMingDistance().hanMingDistance(1, 4);
  }
}
