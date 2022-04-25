package com.decodeme.leetcode.answer;
//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
//
//
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
//
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
//
//
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
//
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组 双指针 👍 1661 👎 0

import com.alibaba.fastjson.JSON;

/**
 * 下一个排序
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        // 思路:从个位开始,找右边比当前值大的数字中最小的一个替换当前数字值
        // 交换后将交换位置以后的数组进行升序排列
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        sort(nums, 0, nums.length);
    }

    /**
     * 排序
     *
     * @param nums  数组
     * @param begin 开始位置
     * @param end   结束位置
     */
    public void sort(int[] nums, int begin, int end) {
        for (int i = begin; i < end; i++) {
            for (int j = i; j < end; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    /**
     * 交换值
     *
     * @param nums 数组
     * @param i    idx-i
     * @param j    idx-j
     */
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = new int[]{1, 3, 2};
        np.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
