package com.yao.sore;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        // 最基本版本
//        baseBubbleSore(array);
        // 进阶版本1
        advancedBubbleSore1(array);
        // 版本2
//        advancedBubbleSore2(array);

//        sort(array);
        System.out.print(Arrays.toString(array));
    }


    /**
     * 最原始的冒泡排序代码
     *
     * @param array
     */
    public static void baseBubbleSore(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 进阶版本1： 对于已经有序的，则做出标记，不需要再进行排序比较。
     *
     * @param array
     */
    public static void advancedBubbleSore1(int array[]) {
        for (int i = 0; i < array.length; i++) {
            // 有序的标记，每一轮的初始值都为true
            Boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }

            }
            // 表示上一轮没有元素交换，则已经有序
            if (isSorted) {
                // 有序，则直接跳出循环
                break;
            }
        }
    }

    /**
     * 进阶版本2： 对于数组后面的有序数列，在每一轮排序后，记录下来最后一次原始交换的位置，该位置即为无序数列的边界，再往后就是有序区。
     *          例如数列： {3, 2, 1, 4, 5, 6, 7, 8}
     *
     * @param array
     */
    public static void advancedBubbleSore2(int array[]) {
        for (int i = 0; i < array.length; i++) {
            // 有序的标记，每一轮的初始值都为true
            Boolean isSorted = true;
            // 无序数列的边界，每次比较只需要比较到这里即可
            int soretBorder = array.length - 1;
            for (int j = 0; j < soretBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 因为有元素交换，所有不是有序的，标记为false
                    isSorted = false;
                    // 把无序数列的边界更新为最后一次交换元素的位置
                    soretBorder = j;
                }
            }
            if (isSorted) {
                // 有序，则直接跳出循环
                break;
            }
        }
    }

    /**
     *  鸡尾酒版本
     * @param array
     */
    public static void sort(int array[])
    {
        int tmp  = 0;
        for(int i=0; i<array.length/2; i++)
        {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for(int j=i; j<array.length-i-1; j++)
            {
                if(array[j] > array[j+1])
                {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }

            //偶数轮之前，重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for(int j=array.length-i-1; j>i; j--)
            {
                if(array[j] < array[j-1])
                {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
}
