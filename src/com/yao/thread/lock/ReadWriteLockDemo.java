package com.yao.thread.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述： 读写锁测试
 *
 * @author pengjie_yao
 * @date 2019/8/6 14:01
 */
public class ReadWriteLockDemo {

    static Lock lock = new ReentrantLock();
    static ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = reentrantReadWriteLock.readLock();
    static Lock writeLock = reentrantReadWriteLock.writeLock();

    int value;

    /**
     *  模拟读操作
     * @param lock
     * @return
     * @throws InterruptedException
     */
    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            // 模拟读操作，读操作的耗时越多，读写锁的优势就越明显
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    /**
     *  模拟写操作
     * @param lock
     * @param index
     * @throws InterruptedException
     */
    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000); // 模拟写操作
            value = index;

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    // 该线程进行读操作
                    demo.handleRead(readLock);
//                    demo.handleRead(lock);
//          demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 该线程进行写操作
        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock, new Random().nextInt());
//          demo.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        /**
         * 使用读写锁，这段程序只需要2秒左右
         * 使用普通的锁，这段程序需要20秒左右。
         */

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnable).start();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("该程序运行时间为："+(endTime-startTime));

    }
}
