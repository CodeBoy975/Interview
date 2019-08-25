package com.yao.thread.pool;

import com.yao.thread.ThreadLocalDemo.ThreadLocalTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述： 线程池的三种创建方式
 *
 * @author pengjie_yao
 * @date 2019/8/5 7:16
 */
public class ThreeThreadPoolDemo {

    public static void main(String[] args) {
        // 三种线程池： 固定、缓存(可变)、单一
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        Thread  thread = new MyThread();
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();
        Thread thread4 = new MyThread();
        // 固定线程池
        fixedThreadPool.execute(thread);
        fixedThreadPool.execute(thread1);
        fixedThreadPool.execute(thread2);
        fixedThreadPool.execute(thread3);
        fixedThreadPool.execute(thread4);
        // 关闭线程池
        fixedThreadPool.shutdown();
       // 结果：只有3个线程在执行
        // 缓存线程池
       /* cachedThreadPool.execute(thread);
        cachedThreadPool.execute(thread1);
        cachedThreadPool.execute(thread2);
        cachedThreadPool.execute(thread3);
        cachedThreadPool.execute(thread4);
        // 关闭线程池
        cachedThreadPool.shutdown();*/
       // 结果：全部线程都执行
        // 单一线程池
       /* singleThreadPool.execute(thread);
        singleThreadPool.execute(thread1);
        singleThreadPool.execute(thread2);
        singleThreadPool.execute(thread3);
        singleThreadPool.execute(thread4);
        // 关闭线程池
        singleThreadPool.shutdown();*/
        // 结果： 只有一个线程在执行


    }
}
