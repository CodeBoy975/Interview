package com.yao.sore;

import java.util.Arrays;

public class HeapOperate {

    public static void main(String[] args) {
        //          1
        //       3      2
        //    6    5  7    8
        //  9       10
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.print(Arrays.toString(array));

        //         7
        //      1      3
        //   10   5  2    8
        // 9    6
        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.print(Arrays.toString(array));
    }

    /**
     * 上浮操作
     *
     * @param array
     */
    public static void upAdjust(int[] array) {
        // 定义子节点的位置
        int childIndex = array.length - 1;
        // 定义父节点的位置，二叉堆是数组实现
        // 左子节点 = 2*parent + 1
        // 右子节点 = 2*parent + 1
        // 所以对于求父节点位置，如下
        int parentIndex = (childIndex - 1) / 2;
        // 定义保存插入节点的位置，用于最后赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            // 子节点=0表示已经浮到最上了, 插入的节点值小于父节点值，才需要进行上浮
            // 小的节点在上，这里模拟的是最小堆的情况
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉操作
     *
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点的值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，则直接跳出
            if (temp <= array[childIndex]) {
                break;
            }
            // 无需真正赋值，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     *  构建堆
     * @param array
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次做“下沉”操作
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }
}
