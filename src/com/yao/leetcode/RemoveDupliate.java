package com.yao.leetcode;

import java.util.Stack;

/**
 * 描述： 删除字符串中所有相邻的字符串
 *
 *
 * @author pengjie_yao
 * @date 2019/7/26 19:30
 */
public class RemoveDupliate {

    /**
     *   abbaca == ca
     *   遍历字符串，如果下一个字符串有连续的，只要判断相邻的如果相同，则移除，然后又返回while循环继续判断,
     *   不断变化字符串，返回判断字符串是否为空
     * @param S
     * @return
     */
    public static  String removeDuplicates(String s) {

        // 1 判断字符串是否为空，空则返回null
        if (s.length() == 0) {
            return null;
        }
        char[] charS = s.toCharArray();
        // 2 遍历数组
        for (int i = 0; i < charS.length-1; i++) {
            if (charS[i] == charS[i + 1]) {
                s = s.substring(0, i) + s.substring(i + 2, s.length());
                charS = s.toCharArray();
                i=-1;
            }
        }

        return  s;
    }

    /**
     *  栈： 通过将字符串压入栈中，判断栈顶元素跟入栈元素是否相等，相等则出栈，否则入栈
     *  59%
     * @param s
     * @return
     */
    public static String removeDuplicates1(String s) {
        Stack<Character> stack = new Stack();
        StringBuffer result = new StringBuffer();
        // 1. 判空
        if (s.length() == 0) {
            return null;
        }
        // 2. 转为字符串，压入栈中
        char[] charArray = s.toCharArray();
        // 3. 如果帧顶元素跟要压入的栈元素相等，则不压入栈，出栈
        for (int i = 0; i < charArray.length; i++) {
            if (!stack.isEmpty() && stack.peek() == charArray[i]) {
                stack.pop();
            }else {
                stack.push(charArray[i]);
            }
        }
        // 4. 出栈后逆序
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    /**
     *  leetcode:78%
     *  栈思想
     *  时间复杂度 遍历n次，所以时间复杂度为O(n)，空间复杂度，用到了StringBuffer，则为O(n)
     * @param s
     * @return
     */
    public static String removeDuplicates2(String s) {
        StringBuffer s2 = new StringBuffer();
        int length = 0;
        // 1. 判空
        if (s.length() == 0) {
            return null;
        }
        char[] charArray = s.toCharArray();
        // 2. 遍历数组
        for (int i = 0; i < charArray.length; i++) {
            // 如果遍历的元素，跟s2中加入的元素相等，则删除到s2中的元素
            if (length != 0 && charArray[i] == s2.charAt(length-1)) {
                s2.deleteCharAt(length-1);
                length--;
            }else {
                s2.append(charArray[i]);
                length++;
            }
        }
        return s2.toString();
    }


    /**
     *  84%
     * @param S
     * @return
     */
    public String removeDuplicates4(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

//        removeDuplicates("abbaca");
//        System.out.println( removeDuplicates1("abbaca"));
        System.out.println(removeDuplicates2("abbaca"));
    }
}
