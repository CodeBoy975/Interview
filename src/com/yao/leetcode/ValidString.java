package com.yao.leetcode;

import java.util.*;

/**
 * 描述： 判断字符串是否有效
 *
 * @author pengjie_yao
 * @date 2019/7/17 16:54
 */
public class ValidString {


    public static void main(String[] args) {
       // 自己解法
        Boolean validString = isValidString("{}[]{}");
        System.out.println(validString);
        // 字符串替换解法
        // Boolean validString = isValidString1("{}[]{}");
        // System.out.println(validString);
        // 网上解法
//        boolean valid = isValid("{}[]{}]");
//        System.out.println(valid);

    }

    /**
     *  法一 使用堆栈
     * @param string
     * @return
     */
    public static Boolean isValidString(String string){
        HashMap<Character,Character> hashMap = new HashMap<>();
        Stack stack = new Stack();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        for (int i = 0; i < string.length(); i++) {
            Character result = string.charAt(i);
            if (! hashMap.containsKey(result)) {
                stack.push(result);
            } else if (stack.isEmpty() || hashMap.get(result) != stack.pop()) {
                return false;
            }
        }
        // 栈为空才返回
        return stack.isEmpty();
    }

    /**
     *  直接替换法，则只要发现有匹配，直接将字符串中对应的括号直接替换掉，最终根据字符串的长度返回结果
     * @param string
     * @return
     */
    public static Boolean isValidString1(String string) {
        int length;
        do {

            length = string.length();
            string = string.replace("()", "").replace("[]", "").replace("{}", "");
        } while (length != string.length());
        return string.length() == 0;
    }


    /**
     *  网上版本，简洁的代码
     * @param s
     * @return
     */
    public static boolean isValid(String s)
    {
        //---------------Use Map----------------------
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<Character>();
        Map<Character,Character> map= new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(char c:chars){
            if(!map.containsKey(c)){
                stack.push(c);
            }
            else if(stack.isEmpty() || map.get(c)!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();

    }
}
