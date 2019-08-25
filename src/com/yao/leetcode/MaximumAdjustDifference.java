package com.yao.leetcode;

import java.util.Arrays;

/**
 * 描述： 无序数组的最大相邻差
 *
 * @author pengjie_yao
 * @date 2019/7/13 18:35
 */
public class MaximumAdjustDifference {

    public static void main(String[] args) {

        int[] array = new int[] {2, 6, 3, 4, 5, 10, 3};
//        int[] array = new int[]{0, 0, 1, 2, 3, 4, 5, 6, 12, 13, 20, 10};
        // 计数排序方式
//        Integer maxAdjustDifference = getMaxAdjustDifference(array);
        int maxSortedDistance = getMaxSortedDistance(array);
        System.out.println("最大相邻差为:"+ maxSortedDistance);

    }

    /**
     *  计数排序思想： 获取无序数组的最大相邻差
     *  步骤：
     *      1. 获取数组中的最大值和最小值，构建数组的长度
     *      2. 将数组依次放入计数排序的数组中
     *      3. 统计空值，判断0值最多连续出现的次数
     *      4. 计算最大相邻差
     * @param array
     * @return
     */
    public static Integer getMaxAdjustDifference(int[] array) {
        // 1. 获取数组中的最大值和最小值，构建数组的长度
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 用来计算在统计数组中的下标
        int distance = max - min;
        int[] countArray = new int[distance+1];
        // 2. 将数组依次放入计数排序的数组中
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        System.out.println("计数排序后的数组为："+Arrays.toString(countArray));
        int maxNearDifference = 0;
        int count = 0;
        // 最大连续数
        int maxCount = 0;
        // 连续的开始位置
        int startIndex = 0;
        // 结束的开始位置
        int endIndex  = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == 0) {
                if (count == 0) {
                    // 记录连续为0的前一个位置
                    startIndex = i-1;
                }
                // 3. 统计空值，判断0值最多连续出现的次数
                count++;
            }else {
                count = 0;
            }
            if (count > maxCount) {
                maxCount = count;
                // 记录连续为0的结束位置的后一个位置
                endIndex = i+1;
            }
        }
        // 4. 计算最大相邻差
        maxNearDifference = endIndex - startIndex;
        return maxNearDifference;
    }

    /**
     *  桶排序思想：获取无序数组的最大相邻差
     *  步骤：
     *      1. 获取数组中的最大值和最小值，构建数组的长度
     *      2. 初始化桶
     *      3. 遍历原始数组，确定每个桶的最大最小值
     *      4. 遍历桶，找到最大差值
     * @param array
     * @return
     */
    public static int getMaxSortedDistance(int[] array) {
        // 1. 获取数组中的最大值和最小值，构建数组的长度
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int distance = max - min;
        // 如果max和min相等，说明数组所有元素都相等，返回0
        if (distance == 0) {
            return 0;
        }
        // 2. 初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        // 3. 遍历原始数组，确定每个桶的最大最小值
        for (int i = 0; i < array.length; i++) {
            // 确定数组元素所属的桶小标
            int index = ((array[i] - min) * (bucketNum - 1)) / distance;
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }

        // 4. 遍历桶，找到最大差值
        // 这里采用临时变量leftMax,在每一轮迭代时存储当前左侧桶的最大值，
        // 而两个桶之间的差值，则是buckets[i].min - leftIndex
        int leftIndex = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftIndex > maxDistance) {
                maxDistance = buckets[i].min - leftIndex;
            }
            leftIndex = buckets[i].max;
        }
        return maxDistance;

    }

    /**
     * 桶
     */
    private static class Bucket{
        Integer min;
        Integer max;
    }
}
