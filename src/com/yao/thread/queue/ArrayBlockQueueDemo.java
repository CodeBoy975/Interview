package com.yao.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 描述： ArrayBlockQueue测试
 *  需求：需求：在多线程操作下，一个数组中最多只能存入 3 个元素。多放入不可以存入数组，
 *              或等待某线程对数组中某个元素取走才能放入，要求使用java的多线程来实现
 *
 * @author pengjie_yao
 * @date 2019/8/5 13:43
 */
public class ArrayBlockQueueDemo {


    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        // 3个线程去存数据
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (true) {
                        try {
                            Thread.sleep((long) Math.random() * 1000);
                            System.out.println(Thread.currentThread().getName() + "准备放数据");
                            arrayBlockingQueue.put(1);
                            System.out.println(Thread.currentThread().getName() + "已经放数据" + "队列中目前有" + arrayBlockingQueue.size() + "个数据");
                        } catch (InterruptedException  e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        /**
         *  启动一个线程去不断取数据
         */
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "准备取数据");
                        System.out.println(arrayBlockingQueue.take());
                        System.out.println(Thread.currentThread().getName() + "已经取走数据" + "队列中目前有" + arrayBlockingQueue.size() + "个数据");
                    } catch (InterruptedException  e) {

                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
