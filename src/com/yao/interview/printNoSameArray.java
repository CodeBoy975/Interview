package com.yao.interview;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 描述： 打出出两个数组相同的元素
 *
 * @author pengjie_yao
 * @date 2019/8/16 11:46
 */
public class printNoSameArray {
    public static void main(String[] args) {
        String[] arr1 = {"112","wqw","2121"};
        String[] arr2 = {"112","aad","ewqw"};
        HashSet<String> set = new HashSet<String>();
        // 将元素放入set中
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        // 遍历数组2
        for (int i = 0; i < arr2.length; i++) {
            boolean contains = set.contains(arr2[i]);
            // 3.如果set中有该元素，则表示是两个数组中的交集元素，输出
            if (contains) {
                System.out.println(arr2[i]);
            }
        }
    }
}
