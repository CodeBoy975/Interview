package com.yao.sourcecode;

import java.io.File;

/**
 * 描述： volatile特性验证
 *
 * @author pengjie_yao
 * @date 2019/7/19 10:12
 */
public class VolatileTest {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();
        for (int i = 0; i < NUMBER; i++) {
                count++;
        }
        //等待减法线程结束
        while (subtractThread.isAlive()) {
            System.out.println("count最后的值为：" + count);
        }
        File file = new File("a");
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                    count--;
            }
        }
    }

}
