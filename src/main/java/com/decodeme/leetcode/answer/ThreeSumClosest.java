package com.decodeme.leetcode.answer;

/**
 * 最接近的三数之和
 *
 * @author yb
 */
public class ThreeSumClosest {

    //    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
    //
    //    例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
    //
    //    与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Integer result = null;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int tempSum = nums[i] + nums[j] + nums[k];
                    if (result != null) {
                        int temp1 = tempSum > target ? tempSum - target : target - tempSum;
                        int temp2 = result > target ? result - target : target - result;
                        result = temp1 > temp2 ? result : tempSum;
                    } else {
                        result = tempSum;
                    }
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2};
        int closest = threeSumClosest(nums, 0);
        System.out.println(closest);
    }
}
