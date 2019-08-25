package com.yao.thread.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * 描述： SynchronousQueue例子
 *
 * @author pengjie_yao
 * @date 2019/8/5 16:29
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<Integer>();

        // 放入元素的线程
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("放入元素1的线程开始" + Thread.currentThread().getName());

                try {
                    synchronousQueue.put(1);
                    System.out.println("放入元素");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程结束");

            }
        });

        // 获取元素的线程
        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("获取线程开始" + Thread.currentThread().getName());

                try {
                    System.out.println("获取元素："+  synchronousQueue.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程结束");

            }
        });

        // 启动线程
        putThread.start();
        Thread.sleep(1000);
        takeThread.start();
    }
}
