package com.yao.collections;

import java.util.Map;

/**
 * 描述： 测试
 *
 * @author pengjie_yao
 * @date 2019/7/16 18:27
 */
public class LinkedHashMapLRUTest {
    public static void main(String[] args) {
        LinkedHashMapLRU<Integer, Integer>  LRU = new LinkedHashMapLRU<Integer, Integer>(3);
        LRU.put(3, 1);
        LRU.put(6, 2);
        LRU.put(9, 3);
        LRU.get(3); //key=3移到顶部
        LRU.put(12, 4);
        LRU.put(15, 5);
        for(Map.Entry<Integer, Integer> entry : LRU.entrySet()) {
            System.out.println(entry.getKey() + " " +entry.getValue());
        }
    }
}
