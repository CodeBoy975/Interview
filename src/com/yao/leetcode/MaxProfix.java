package com.yao.leetcode;

/**
 * 描述： 买卖股票问题
 *
 * @author pengjie_yao
 * @date 2019/7/29 22:40
 */
public class MaxProfix {

    /**
     *  使用贪心算法
     *  时间复杂度为O(n)
     *  空间复杂度为O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        // 1. 对数组进行判断处理
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        // 2. 遍历数组，如果后一天的数值比前一天大，则前一天的卖出去
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i + 1]) {
                max = max+ prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
