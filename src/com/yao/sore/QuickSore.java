package com.yao.sore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSore {

    public static void main(String[] args) {

        int[] array = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
//        QuickSore(array, 0, array.length - 1);
        quickSort(array,0,array.length-1);
        System.out.print(Arrays.toString(array));

    }


    /**
     * 双边循环方式的递归方式实现
     *
     * @param array
     * @param startPoint
     * @param endPoint
     */
    public static void quickSore(int[] array, int startPoint, int endPoint) {
        // 1 如果开始的位置大于结束的位置，跳出循环
        if (startPoint >= endPoint) {
            return;
        }
        // 2 获取基准元素
        int basePoint = partition(array, startPoint, endPoint);
        // 3 将基准元素左边再进行快排
        quickSore(array, startPoint, basePoint - 1);
        // 4 将基准元素右边进行快排
        quickSore(array, basePoint + 1, endPoint);
    }

    /**
     * 双边循环法：获取基准元素
     * 注意： 一定要先从右边开始
     *
     * @param array
     * @param startPoint
     * @param endPoint
     * @return
     */
    private static int partition(int[] array, int startPoint, int endPoint) {
        // 1 获取第一个元素作为基准元素
        int baseValue = array[startPoint];
        // 2 设置左右指针
        int leftPoint = startPoint;
        int rightPoint = endPoint;
        while (leftPoint != rightPoint) {
            // 3 右指针向左移动的情况
            while (leftPoint < rightPoint && array[rightPoint] > baseValue) {
                rightPoint--;
            }
            // 4 左指针向右移动的情况
            while (leftPoint < rightPoint && array[leftPoint] <= baseValue) {
                leftPoint++;
            }

            // 5 交换left和right指针所指向的元素
            if (leftPoint < rightPoint) {
                int temp = array[leftPoint];
                array[leftPoint] = array[rightPoint];
                array[rightPoint] = temp;
            }
        }
        // 6 最终左右指针重合出，则是我们的基准元素的位置,而我们一开始，我们的基准元素就取第一个位置
        //   这里的array[leftPoint]，也可以换为array[rightPoint]，因为此时左右指针是重合状态
        array[startPoint] = array[leftPoint];
        array[leftPoint] = baseValue;
        return leftPoint;
    }

    /**
     * 单边循环法获取基准元素
     *
     * @param array
     * @param startPoint
     * @param endPoint
     * @return
     */
    private static int partition1(int[] array, int startPoint, int endPoint) {
        // 基准元素值
        int baseValue = array[startPoint];
        // 表示小于基准元素的区域边界
        int mark = startPoint;
        for (int i = startPoint; i <= endPoint; i++) {
            // 小于基准元素，则对应代表小于基准元素的边界扩大，并交换彼此的位置
            if (array[i] < baseValue) {
                mark++;
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }
        array[startPoint] = array[mark];
        array[mark] = baseValue;
        return mark;
    }

    /**
     *   单边循环方式的递归方式实现
     * @param array
     * @param startPoint
     * @param endPoint
     */
    public static void quickSore1(int[] array, int startPoint, int endPoint) {
        // 1 如果开始的位置大于结束的位置，跳出循环
        if (startPoint >= endPoint) {
            return ;
        }
        // 2 获取基准元素
        int basePoint = partition1(array, startPoint, endPoint);
        // 3 将基准元素左边再进行快排
        quickSore1(array, startPoint, basePoint - 1);
        // 4 将基准元素右边进行快排
        quickSore1(array, basePoint + 1, endPoint);
    }

    /**
     *  非递归方式实现
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();

        // 先将首尾指针压入栈中
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件为栈为空，则循环结束
        while (!quickSortStack.isEmpty()) {
            // 弹出栈
            Map<String, Integer> param = quickSortStack.pop();
            // 获取基准元素
            int basePoint = partition(arr, param.get("startIndex"), param.get("endIndex"));
            // 根据基准元素进行入栈
            if (param.get("startIndex") < basePoint - 1) {
                // 入栈
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", basePoint - 1);
                quickSortStack.push(leftParam);
            }

            if (param.get("endIndex") > basePoint + 1) {
                // 入栈
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", basePoint+1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }


}
