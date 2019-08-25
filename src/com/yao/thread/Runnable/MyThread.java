package com.yao.thread.Runnable;

/**
 * 描述： 继承Thread实现Runnable接口
 *
 * @author pengjie_yao
 * @date 2019/8/1 15:50
 */
public class MyThread extends Thread {
    @Override
    public void run() {

        for (int i = 100; i > 0; i--) {
            System.out.println(i);
        }
    }
}
