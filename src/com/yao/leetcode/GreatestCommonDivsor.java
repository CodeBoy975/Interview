package com.yao.leetcode;

/**
 * 描述： 求两个数的最大公约数
 *
 * @author pengjie_yao
 * @date 2019/7/13 11:37
 */
public class GreatestCommonDivsor {


    /**
     * 利用辗转相除法的递归方式求解
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatestCommonDivsor(Integer a, Integer b) {
        int big = a > b ? a : b;
        int smaller = a < b ? a : b;
        if (big % smaller == 0) {
            return smaller;
        }
        return getGreatestCommonDivsor(big % smaller, smaller);
    }

    /**
     * 利用更相减损法的递归方式求解
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatestCommonDivsor1(Integer a, Integer b) {
        int big = a > b ? a : b;
        int smaller = a < b ? a : b;
        if (big % smaller == 0) {
            return smaller;
        }
        return getGreatestCommonDivsor(big - smaller, smaller);
    }

    /**
     * 结合辗转相除法以及更相减损法的最优算法
     * 解法：
     * 当a和b均为偶数，gcb(a,b) = 2*gcb(a/2, b/2) = 2*gcb(a>>1, b>>1)
     * 当a为偶数，b为奇数，gcb(a,b) = gcb(a/2, b) = gcb(a>>1, b)
     * 当a为奇数，b为偶数，gcb(a,b) = gcb(a, b/2) = gcb(a, b>>1)
     * 当a和b均为奇数，利用更相减损术运算一次，gcb(a,b) = gcb(b, a-b)， 此时a-b必然是偶数，又可以继续进行移位运算。
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatestCommonDivsor2(Integer a, Integer b) {
        if (a == b) {
            return a;
        }
        // a&1 == 0说明整数a是偶数，否则为奇数
        if ((a & 1) == 0 && (b & 1) == 0) {
            // 当a和b均为偶数，gcb(a,b) = 2*gcb(a/2, b/2) = 2*gcb(a>>1, b>>1)
            return getGreatestCommonDivsor2(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            // 当a为偶数，b为奇数，gcb(a,b) = gcb(a/2, b) = gcb(a>>1, b)
            return getGreatestCommonDivsor2(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            // 当a为奇数，b为偶数，gcb(a,b) = gcb(a, b/2) = gcb(a, b>>1)
            return getGreatestCommonDivsor2(a, b >> 1);
        } else {
            // 当a和b均为奇数，利用更相减损术运算一次，gcb(a,b) = gcb(b, a-b)， 此时a-b必然是偶数，又可以继续进行移位运算。
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatestCommonDivsor2(big - small, small);
        }
    }

    public static void main(String[] args) {

        // 辗转相除法
//        Integer result = getGreatestCommonDivsor(12, 8);
        // 更相减损法
//        Integer result = getGreatestCommonDivsor1(12, 8);
        // 最优算法
//        Integer result = getGreatestCommonDivsor2(12, 8);
        Integer result = getGreatestCommonDivsor2(10, 25);

        System.out.println("两者的最大公约数为：" + result);

    }
}
