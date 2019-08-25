package com.yao.interview;

import java.util.*;

/**
 * 描述： Map的遍历方式
 *
 * @author pengjie_yao
 * @date 2019/8/20 22:24
 */
public class MapPrint {

    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>(16);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        arrayList.add(map);

        HashMap<String, String> map1 = new HashMap<>(16);
        map1.put("5", "d");
        map1.put("6", "c");
        map1.put("7", "b");
        map1.put("8", "a");
        arrayList.add(map1);

        // 第一种遍历方式
        System.out.println("第一种遍历方式；");
        for (HashMap map2 : arrayList) {
            // 1.获取map的keySet
            Set set = map2.keySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                String values = (String) map2.get(key);
                System.out.print(key+":"+values+" ");
            }
            System.out.println();
        }

        // 第二种遍历方式
        System.out.println("第二种遍历方式：");
        for (HashMap map2 : arrayList) {
            // 1.获取map的entrySet
            Set set = map2.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                System.out.print(key+":"+value+" ");
            }
            System.out.println();
        }
    }
}
