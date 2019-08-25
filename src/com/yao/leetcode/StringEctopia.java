package com.yao.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 描述： 有效的字符串异位词
 * 题目：
 *  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 * 示例 2:
 *      输入: s = "rat", t = "car"
 *      输出: false
 *
 * @author pengjie_yao
 * @date 2019/7/22 19:59
 */
public class StringEctopia {

    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "cba"));
        System.out.println(isAnagram("abc", "cda"));
    }

    /**
     *  判断字符串异位: 排序方式： 通过比较排序后的数组是否相等
     *
     * @param s
     * @param t
     * @return
     */
    public static Boolean isAnagram(String s, String  t) {
        // 1. 如果长度不一致，则直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 2. 对两个字符串进行排序，比较排序后的结果
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    /**
     *  判断字符串异位: map方式，通过比较出现元素的个数
     *
     * @param s
     * @param t
     * @return
     */
    public static Boolean isAnagram1(String s, String  t) {
        // 1. 如果长度不一致，则直接返回false
        if (s.length() != t.length()) {
            return false;
        }

        // 2. 转化为数组
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        // 用来存储t和s中出现字符的次数
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>(16);
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>(16);
        for (int i = 0; i < s.length(); i++) {
            // 3. 将每个字母出现的次数统计到集合中
            if (mapS.get(chars[i]) == null){
                mapS.put(chars[i], 0);
            }else {
                mapS.put(chars[i], mapS.get(chars[i]) + 1);
            }
            if (mapT.get(chart[i]) == null){
                mapT.put(chart[i], 0);
            }else {
                mapT.put(chart[i], mapT.get(chart[i]) + 1);
            }
        }
        return mapS.equals(mapT);
    }
}
