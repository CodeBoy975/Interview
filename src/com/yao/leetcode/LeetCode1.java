package com.yao.leetcode;

import java.util.Stack;

/**
 * 描述：  给定一个整数，从该整数中去掉k个数字，要求剩下的数字形成的新整数尽可能小
 * 解题思路： 把原整数的所有数字从左到右进行比较，如果发现某一位数字大于它右边的数字，那么在删除该数字后，必然会使该数位的值降低。
 * @author pengjie_yao
 * @date 2019/7/14 15:24
 */
public class LeetCode1 {

    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits1("10",2));
    }

    public static String removeKDigits(String num, int k) {
        String numNew = num;
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            // 从左到右遍历，找到比自己右侧数字大的数字并删除
            for (int j = 0; j < numNew.length() - 1; j++) {
                if (numNew.charAt(j) > numNew.charAt(j + 1)) {
                    numNew = numNew.substring(0, j) + numNew.substring(j + 1, numNew.length());
                    hasCut = true;
                    break;
                }
            }
            // 如果没有找到要删除的数字，则删除最后一个数字
            if (!hasCut) {
                numNew = numNew.substring(0, numNew.length() - 1);
            }
            // 清除整数左侧的数字0
            numNew = removeZero(numNew);
        }
        // 如果整数的所有数字都被删除了，直接返回0
        if (numNew.length() == 0) {
            return "0";
        }
        return numNew;
    }

    /**
     *  清除整数左侧的数字"0"
     * @param num
     * @return
     */
    private static String removeZero(String num) {
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(0) != '0') {
                break;
            }
            num = num.substring(1, num.length());
        }
        return num;
    }


    /**
     *  优化版本: 删除整数的k个数字，获取删除后的最小值
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigits1(String num, int k){
        // 1 构建一个栈
        int newLength = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        // 2 外层循环为数组的循环，如果发现压入的元素大于栈顶元素，则先弹出栈顶元素，再压入元素
        for (int i = 0; i < num.length(); i++) {
            // 遍历当前数字
            char c = num.charAt(i);
            // 当栈顶数字大于遍历到的当前数字时，栈顶数字出栈(相当于删除数字)
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            // 遍历到当前的数字入栈
            stack[top++] = c;
        }
        // 3 返回删除后的整数
        // 找到栈中第1个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }
}
