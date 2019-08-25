package com.yao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 描述： 大整数的相加
 * 思路：
 *        采用两个数组分别存储数据
 *        将两个数组逆序后计算
 *        将计算出的结果数组逆序后再输出
 *
 *
 * @author pengjie_yao
 * @date 2019/7/15 20:01
 */
public class BigInteger {
    public static void main(String[] args) {

        int[] arrayA = new int[]{1, 2, 3};
        int[] arrayB = new int[]{9, 3, 9};
        int[] arrayC = addBigInteger(arrayA, arrayB);
        System.out.println(Arrays.toString(arrayC));
    }

    /**
     * 两个数组数组的相加
     *
     * @param arrayA
     * @param arrayB
     * @return
     */
    public static int[] addBigInteger(int[] arrayA, int[] arrayB) {

        // 1. 数组A逆序
        for (int start = 0, end = arrayA.length - 1; start < end; start++, end--) {
            int temp = arrayA[start];
            arrayA[start] = arrayA[end];
            arrayA[end] = temp;
        }

        // 2. 数组B逆序
        for (int start = 0, end = arrayB.length - 1; start < end; start++, end--) {
            int temp = arrayB[start];
            arrayB[start] = arrayB[end];
            arrayB[end] = temp;
        }
        // 取A、B数组中长的为C数组长度，
        int length = arrayA.length > arrayB.length ? arrayA.length : arrayB.length;
        // 3. 计算的结果
        int[] arrayC = new int[length + 1];
        for (int i = 0; i < length; i++) {
            int result = arrayA[i] + arrayB[i];
            if (result >= 10) {
                // 取余，比如11，则取后为1，填充原位置为1
                result = result % 10;
                // 进位则下一位的数据先填充1
                arrayC[i + 1] = 1;
            }
            // 这里的+=主要是考虑到如果进位，则此时已经有值的情况。
            arrayC[i] +=  + result;
        }
        // 数组C逆序
        for (int start = 0, end = arrayC.length - 1; start < end; start++, end--) {
            int temp = arrayC[start];
            arrayC[start] = arrayC[end];
            arrayC[end] = temp;
        }
        return arrayC;
    }

}
