package com.decodeme.leetcode.answer;

/**
 * 两数之和
 */
public class TwoSum {
    //    给定 nums = [2, 7, 11, 15], target = 9
    //
    //    因为 nums[0] + nums[1] = 2 + 7 = 9
    //    所以返回 [0, 1

    public int[] twoSum(int[] nums, int target) {
        for (int i = nums.length - 1; i > 0; i--) {
            // if(nums[i] > target){
            //     continue;
            // }
            for (int j = 0; j < i; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] {j, i};
                }
            }
        }
        return null;
    }
}
