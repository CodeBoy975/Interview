package com.yao.leetcode;

import static java.lang.Integer.MIN_VALUE;

/**
 * 描述： Pow(x,n),即计算 x 的 n 次幂函数。
 *
 * @author pengjie_yao
 * @date 2019/7/27 15:24
 */
public class PowOfTwo {


    public static void main(String[] args) {
//        System.out.println(myPow(2, 2));
        System.out.println(myPow1(1.00000 ,-2147483648));


    }


    /**
     * @param x
     * @param n
     * @return
     */
    public static  double myPow(double x, int n) {
        // 将n转为长整型，否则当n为负数，转为正数会溢出，所以这里直接另外新建一个函数来完成
        long n1 = n;
        return divide(x,n1);


    }

    /**
     *  分治算法 ：
     *          1. 递归出口，如果是n=0则返回1
     *          2. 如果n小于0的情况，则要将x进行倒数，并且n变为正数
     *          3. 将n分为2部分，则
     *                      当n为偶数时，我们只要计算其中一部分的值为y，则返回的结果为y*y即可
     *                    当n为奇数时，则我们提取出一个x出来，此时又变为偶数，则返回结果为x*y*y即可。
     * @param x
     * @param n
     * @return
     */
    private static double divide(double x, long n) {
        // 如果n小于0的情况，则要将x进行倒数，并且n变为正数
            if (n < 0) {
            n = -n;
            x = 1/x;
        }
        // 1. 递归出口，如果是n=0则返回1
        if (n == 0) {
            return 1.0;
        }
        // 2. 递归进行获取结果
        double y = divide(x, n/2);

        // 根据n的奇偶数返回结果集
        if (n % 2 == 0) {
            return y * y;
        }else {
            return x * y * y;
        }
    }

    /**
     *  非递归方式
     * @param x
     * @param n
     * @return
     */
    public static  double myPow1(double x, int n) {
        // 将n转为长整型，否则当n为负数，转为正数会溢出，所以这里直接另外新建一个函数来完成
        long n1 = n;
        double y = 1;

        // 1.  如果n小于0的情况，则要将x进行倒数，并且n变为正数
        if (n1 < 0) {
            // 如果为负数，则转为正，这里不能是n1 = -n,这样如果负数是最小值，转为正会溢出
            n1 = -n1;
            x = 1/x;
        }

        while (n1 != 0) {
            // 非递归方式的话，每次怎样判断n的幂次，
            if ((n1 & 1) != 0 ) {
                // 奇数情况,比如5对应二进制为0101,则0101 & 0001 = 0001,所以不等于0，为奇数
                y = y * x;
            }
            // x进行叠乘
            x = x*x;
            // 这里相当于将n1/2，右移操作
            n1  = n1>>1;
        }

        return y;
    }


}
