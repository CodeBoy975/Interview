package com.yao.thread.Runnable;

/**
 * 描述： 多线程的启动方式
 *
 * @author pengjie_yao
 * @date 2019/8/1 15:47
 */
public class MyRunnable implements  Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
