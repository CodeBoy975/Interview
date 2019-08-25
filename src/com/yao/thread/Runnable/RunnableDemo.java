package com.yao.thread.Runnable;

/**
 * 描述： 测试多线程的实现方式
 *
 * @author pengjie_yao
 * @date 2019/8/1 15:48
 */
public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable);
//        thread.start();

        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
//        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("didid" + i);
                }
            }
        });
        thread2.start();

    }
}
