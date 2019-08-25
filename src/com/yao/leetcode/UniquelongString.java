package com.yao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目 ：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 例如：
 *        输入: "abcabcbb"
 *        输出: 3
 *
 * @author pengjie_yao
 * @date 2019/7/17 11:38
 */
public class UniquelongString {

    public static void main(String[] args) {

        // 第一种HashSet解法
//        int result = uniqueLongString("ABCBBCDAB");
        // 第二种 HashMap解法
        int result = uniqueLongString1("abcbad");
        System.out.println(result);
    }

    /**
     *  使用HashSet的解法
     *   该方法的时间复杂度： O(2n) = O(n)
     *   空间复杂度为：O(min(m,n))滑动窗口法需要 O(k)O(k) 的空间，
     *                其中 k 表示 Set 的大小。而 Set 的大小取决于字符串 nn 的大小以及字符集 / 字母 mm 的大小。
     * @param chars
     * @return
     */
    public static int uniqueLongString(String chars) {
        int length = chars.length();
        // 用来保存无重复的最长字符串
        Set<Character> hashSets = new HashSet<>();
        int max = 0;
        // 左指针
        int i = 0;
        // 右指针
        int j = 0;
        while (i < length && j < length) {
            // 1 如果set中有该元素，说明有重复出现，则将左指针向右移动
            if (hashSets.contains(chars.charAt(j))) {
                // 已有字符串
                hashSets.remove(chars.charAt(i));
                i++;
            }else {
                // 2 如果set中没有该元素，说明是新元素，则将右指针向右移动
                hashSets.add(chars.charAt(j));
                j++;
                // 最大连续数则取左右指针的差值与当前最大连续数之间的最大值
                 max = Math.max(max, j - i);
            }
        }
        return max;
    }

    /**
     *  使用HashMap的解法：
     *  例如：  s[j] 在 [i, j)[i,j) 范围内有与 j'重复的字符，我们不需要逐渐增加i。
     *         我们可以直接跳过 [i，j'] 范围内的所有元素，并将 i 变为 j' + 1
     *
     * @param chars
     * @return
     */
    public static int uniqueLongString1(String chars){

        int length = chars.length();

        Map<Character, Integer> map = new HashMap<>();
        // 左区域指针
        int i=0;
        // 右区域指针
        int j=0;
        int max = 0;
        for (j=0; j < length; j++) {
            if (map.containsKey(chars.charAt(j))) {
                i = Math.max(map.get(chars.charAt(j)), i);
//                i = map.get(chars.charAt(j));
            }
            map.put(chars.charAt(j), j);
            max = Math.max(max, j - i);
        }
        return max;
    }
}
