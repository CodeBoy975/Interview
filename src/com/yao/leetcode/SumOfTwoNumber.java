package com.yao.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 描述： 两数之和
 * 思路：
 * 法一： 使用HashMap方式来解题，通过存储key为数组中的数值，value为数组的下标，然后每次遍历数组，判断map中的key是否等于目标值与数组的差值，是则返回；
 * 时间复杂度为： O(n)，空间复杂度为： O(n)
 * 法二； 也是使用HashMap方式，但只需要一次hash，因为我们循环时可以判断是否map中有我们要的差值，如果没有，我们则将值放入map中。
 *
 * @author pengjie_yao
 * @date 2019/7/17 10:01
 */
public class SumOfTwoNumber {

    public static void main(String[] args) {

        int[] array = new int[]{2, 7, 11, 15};
        // 两遍哈希
        int[] result = addTwoNumber(array, 9);
        // 一遍哈希
//        int[] result = addTwoNumber1(array, 5);
        if (result == null) {
            System.out.println("数组中不存在两个数相加等于输入的目标值");
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * 两次Hash方式求解
     *
     * @param targe
     * @return
     */
    public static int[] addTwoNumber(int[] array, int targe) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 1 将差值保存到hash中
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        // 2 从hash中获取
        for (int i = 0; i < array.length; i++) {
            int temp = targe - array[i];
            if (map.containsKey(temp) ) {
                return new int[]{i, map.get(temp)};
            }
        }
        // 没有找到则返回空
        return null;
    }

    /**
     * 一次Hash方式求解
     *
     * @param targe
     * @return
     */
    public static int[] addTwoNumber1(int[] array, int targe) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 2 从hash中获取
        for (int i = 0; i < array.length; i++) {
            int temp = targe - array[i];
            // 如果map中已经能找到差值，则直接返回
            if (map.containsKey(temp)) {
                return new int[]{i, map.get(temp)};
            }
            // 将数值放入map中
            map.put(array[i], temp);

        }
        // 没有找到则返回空
        return null;
    }
}
