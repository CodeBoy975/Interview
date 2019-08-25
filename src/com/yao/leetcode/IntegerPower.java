package com.yao.leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.net.URL;

/**
 * 描述： 如何判断一个数是否是2的整数次幂
 *
 * @author pengjie_yao
 * @date 2019/7/13 12:09
 */
public class IntegerPower {

    public static void main(String[] args) {

        /*System.out.println("该数是否为2的整数次幂：" + isIntegePower(16));
        System.out.println("该数是否为2的整数次幂：" + isIntegePower(32));
        System.out.println("该数是否为2的整数次幂：" + isIntegePower(25));
        ClassLoader classLoader = IntegerPower.class.getClassLoader();
        ClassLoader classLoader1 = classLoader.getParent();
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader);
        System.out.println(classLoader1);
        System.out.println(classLoader2);*/
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (java.net.URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }

    /**
     *  判断是否是2的整数次幂
     * @param number
     */
    public static Boolean isIntegePower(Integer number) {

        // 1.如果小于或者等于0，肯定不是2的幂次方
        if (number <= 0) {
            return false;
        }
        // 2.将该数与比它小1进行相与操作
        if ((number & (number - 1)) == 0) {
            return true;
        }
        return false;
    }
}
