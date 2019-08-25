package com.yao.interview;

/**
 * 描述： 阶乘和
 *
 * @author pengjie_yao
 * @date 2019/8/24 8:36
 */
public class FactorialSum {

    /**
     * 非递归方式
     *
     * @param n
     * @return
     */
    public static Integer factorialSum(int n) {
        // 1.n判断，如果小于0或者等于0则返回1
        if (n <= 0) {
            return 1;
        }
        // 统计和
        int sum = 0;
        // 2.求出阶乘和
        while (n != 0) {
            int sum1 = 1;
            int n1 = n;
            // 3.求出每个阶乘的和
            while (n1 != 0) {
                sum1 = sum1 * n1;
                n1--;
            }
            // 4.将每个阶乘的和进行相加
            sum = sum + sum1;
            n--;
        }
        return sum;
    }


    /**
     * 递归方式求和
     *
     * @param n
     * @return
     */
    public static Integer factorialSum1(int n) {

        // 1.判断n是否小于0的数
        if (n <= 0) {
            return 1;
        }

        int sum = 0;
        // 2. 遍历
        for (int i = 1; i <= n; i++) {
            // 2.递归返回后进行求和
            sum = sum + factorial(i);
        }
        return sum;
    }

    /**
     * 求解阶乘
     *
     * @param n 阶乘的数
     * @return
     */
    private static int factorial(int n) {
        // 1.递归出口
        if (n <= 1) {
            return 1;
        }
        // 2.阶乘
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
//        Integer integer = factorialSum(3);
        Integer integer = factorialSum1(3);
        System.out.println(integer);
    }
}
