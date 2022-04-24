package com.decodeme.leetcode.answer;

import com.decodeme.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrderTransfer {
    //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 广度优先搜索 二叉树 👍 1291 👎 0

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 返回结果
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> treeNodeList = Arrays.asList(root);
        while (treeNodeList != null && treeNodeList.size() > 0) {
            List<TreeNode> tmpList = new ArrayList<>();
            List<Integer> tmpLevelList = new ArrayList<>();
            for (TreeNode node : treeNodeList) {
                // 存放当前层的值
                tmpLevelList.add(node.val);
                // 将下一层的左子树放入
                if (node.left != null) {
                    tmpList.add(node.left);
                }
                // 将下一次层右子树放入
                if (node.right != null) {
                    tmpList.add(node.right);
                }
            }
            // 如果结果非空则增加值
            if (tmpLevelList != null && tmpLevelList.size() > 0) {
                result.add(tmpLevelList);
            }
            // 替换要遍历的list
            treeNodeList = tmpList;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        LevelOrderTransfer transfer = new LevelOrderTransfer();
        transfer.levelOrder(root);
    }
}
