package com.decodeme.leetcode.answer;

import org.springframework.util.StopWatch;

/**
 * 62.不同路径
 */
public class UniquePaths {

    //路径数
    int counts = 0;

    /**
     * 可解问题，但是会存在超时的情况
     *
     * @param m m行
     * @param n n列
     * @return 结果
     */
    public int uniquePaths(int m, int n) {
        // 设定有m行，n列的格子，求左上角到右下角的路径有多少？
        if (m <= 0 || n <= 0) {
            return 0;
        }
        // 递归计算路径信息
        go(1, 1, m, n);
        return counts;
    }

    /**
     * 走一步
     *
     * @param posM 当前的行
     * @param posN 当前的列
     * @param m    最大的行
     * @param n    最大的列
     */
    private void go(int posM, int posN, int m, int n) {
        if (posM > m || posN > n) {
            return;
        }
        if (posM == m && posN == n) {
            counts++;
            return;
        }
        // 向右走
        go(++posM, posN, m, n);
        // 向下走(要回撤多往右走的路径)
        go(--posM, ++posN, m, n);
    }

    /**
     * 题解的解法，当前位置，要么是从上方到达（m-1, n），要么从自己左方到达（m, n-1)，
     * 所以知道到达这两个位置的路径数，他们之和就是(m, n)的路径数
     *
     * @param m m行
     * @param n n列
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        StopWatch st = new StopWatch();
        st.start("递归");
        System.out.println(uniquePaths.uniquePaths(19, 13));
        st.stop();
        st.start("叠加");
        System.out.println(uniquePaths.uniquePaths2(19, 13));
        st.stop();
        System.out.println(st.prettyPrint());
    }
}
