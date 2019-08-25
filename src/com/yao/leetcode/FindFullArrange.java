package com.yao.leetcode;

import java.util.Arrays;

/**
 * 描述： 给出一个正整数，找出这个正整数所有数字全排列的下一个数
 *    通俗理解就是： 在一个整数所包含数字的全部组合中，找到一个大于且仅大于原数的新整数
 *    例如：
 *      如果输入12345，返回12354
 *      如果输入12354，返回12435
 *      如果输入12435, 返回12453
 *
 * (字典序算法)
 *  步骤：
 *      1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
 *      2. 让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置
 *      3. 把原来的逆序区域换为顺序区域
 * @author pengjie_yao
 * @date 2019/7/14 13:47
 */
public class FindFullArrange {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4,5};
        for (int i = 0; i < 10; i++) {
            numbers =  findNearestNumber(numbers);
            if (numbers != null) {
                outputNumbers(numbers);
            }
        }
    }


    /**
     *  找到全排列的下一个数
     * @param array
     * @return
     */
    public static int[] findNearestNumber(int[] array) {
        // 1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
        int index = findTransferPoint(array);
        if (index == 0) {
            return null;
        }
        // 2. 让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置
        int[] numberCopy = Arrays.copyOf(array, array.length);
        numberCopy = exchangeHead(numberCopy, index);
        // 3. 把原来的逆序区域转为顺序
        numberCopy = reverse(numberCopy, index);
        return numberCopy;
    }

    /**
     *
     *  获取逆序区域的前一位,比如 12354, 则54是逆序，则获取逆序对应的位置，即5的小标
     * @param array
     * @return
     */
    private static int findTransferPoint(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            // 从后往前比较：大于前一个数则返回
            if (array[i] > array[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    /**
     *  在逆序区域的前一位和逆序区域大于它的最小数字交换位置,
     *   例如： 12354，则前一位是3，大于它的最小数字为4，从而变成12453
     * @param numberCopy
     * @param index
     */
    private static int[] exchangeHead(int[] numberCopy, int index) {
        // 保存逆序区域的前一位数值
        int head = numberCopy[index - 1];
        for (int i = numberCopy.length - 1; i > 0; i--) {
            if (head < numberCopy[i]) {
                numberCopy[index-1] = numberCopy[i];
                numberCopy[i] = head;
                break;
            }
        }
        return numberCopy;
    }


    /**
     *  将逆序区域转为顺序
     * @param numberArray
     * @param index
     */
    private static int[] reverse(int[] numberArray, int index) {
        // 12354
        // 12435
        for (int i = index, j = numberArray.length - 1; i < j; i++, j--) {
            int temp = numberArray[i];
            numberArray[i] = numberArray[j];
            numberArray[j] = temp;
        }
        return numberArray;
    }

    /**
     *  输出数组
     * @param numbers
     */
    private static void outputNumbers(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i);
        }
        System.out.println();
    }

}
