package com.decodeme.leetcode.answer;

import lombok.val;

public class RemoveElement {
    //    给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    //
    //    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    //
    //    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    //
    //    示例 1:
    //
    //    给定 nums = [3,2,2,3], lombok.val = 3,
    //
    //    函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
    //
    //    你不需要考虑数组中超出新长度后面的元素。

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        count++;
                        break;
                    }
                }
                continue;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = new int[] {3, 2, 2, 3};
        int i = re.removeElement(nums, 3);
        System.out.println(i);
    }
}
