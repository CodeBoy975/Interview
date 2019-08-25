package com.yao.interview;

/**
 * 描述： 反转字符串
 *  题目：1 对字符串进行逆序，输入 hello，要求输出 olleh
 *
 * @author pengjie_yao
 * @date 2019/8/11 17:22
 */
public class ReverseString {



    public static void main(String[] args) {
        char[] array = new char[]{'h','e','l','l','o'};
        reverseString(array);
        System.out.println(array.toString());
    }

    /**
     *   反转字符串
     * @param s
     */
    public static void reverseString(char[] s) {

        // 1.判空
        if (s == null) {
            return ;
        }
        // 2.遍历字符串，将首尾进行逐一交换
         for (int i = s.length-1,j=0; i >= j; i--,j++) {
             char temp = s[i];
             s[i] = s[j];
             s[j] = temp;
        }
    }
}
