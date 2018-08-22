package com.decodeme.leetcode.answer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 四数之和，解法并不优雅，多重for循环会导致查询效率极速下降，待优化
 * 可以参考：https://blog.csdn.net/MebiuW/article/details/50938326
 */
public class FourNumberSum {
    //
    //    给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target
    // 相等？找出所有满足条件且不重复的四元组。
    //
    //    注意：
    //
    //    答案中不可以包含重复的四元组。
    //
    //    示例：
    //
    //    给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
    //
    //    满足要求的四元组集合为：
    //            [
    //            [-1,  0, 0, 1],
    //            [-2, -1, 1, 2],
    //            [-2,  0, 0, 2]
    //            ]

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        int length = nums.length;
        Set<String> flagSet = new HashSet<>();
        for (int i = 0; i <= length - 4; i++) {
            for (int j = i + 1; j <= length - 3; j++) {

                for (int k = j + 1; k <= length - 2; k++) {

                    for (int l = k + 1; l <= length - 1; l++) {

                        System.out.println(
                                "numi:" + nums[i] + " numj:" + nums[j] + " numk:" + nums[k] + " numl:" + nums[l]);
                        if ((nums[i] + nums[j] + nums[k] + nums[l]) == target) {
                            String sort = sort(nums[i], nums[j], nums[k], nums[l]);
                            if (flagSet.contains(sort)) {
                                continue;
                            }
                            flagSet.add(sort);
                            List<Integer> tempList = new ArrayList<>();
                            tempList.add(nums[i]);
                            tempList.add(nums[j]);
                            tempList.add(nums[k]);
                            tempList.add(nums[l]);
                            result.add(tempList);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static String sort(int num1, int num2, int num3, int num4) {
        int[] arr = new int[] {num1, num2, num3, num4};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {//-1为了防止溢出
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;
                }
            }
        }
        return new StringBuilder().append(arr[3]).append(arr[2]).append(arr[1]).append(arr[0]).toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 0, 0};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            System.out.println(" " + list.get(0) + " " + list.get(1) + " " + list.get(2) + " " + list.get(3));
        }
    }
}
