package com.decodeme.leetcode;


public class TestMethod {

  public static void main(String[] args) {
    //
    int a = 100, b = 2;
    a = a | b;
    b = a ^ b;
    a = a ^ b;
    System.out.println(a);
    System.out.println(b);
  }
}
