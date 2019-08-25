package com.yao.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述： 重入锁测试
 *
 * @author pengjie_yao
 * @date 2019/8/6 11:31
 */
public class LockTest implements Runnable {
    /**
     * Re - entrant - Lock
     * 重入锁，表示在单个线程内，这个锁可以反复进入，也就是说，一个线程可以连续两次获得同一把锁。
     * 如果你不允许重入，将导致死锁。注意，lock 和 unlock 次数一定要相同，如果不同，就会导致死锁和监视器异常。
     *
     * synchronized 只有2种情况：1继续执行，2保持等待。
     */
    static Lock lock = new ReentrantLock();
    static int i;


    @Override
    public void run() {
        // 1. 遍历进行自增到1000000
        for (int j = 0; j < 1000000; j++) {
            // 2.获取锁
            lock.lock();
            try {
                // 3.进行资政
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 4.释放锁
               // 因为lock 如果发生了异常，是不会释放锁的，所以必须在 finally 块中释放锁
            // synchronized 发生异常会主动释放锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        Thread thread = new Thread(lockTest);
        Thread thread1 = new Thread(lockTest);
        // 启动两个线程
        thread.start();
        thread1.start();

        // 等待这个线程结束，主线程会等待子线程执行完成之后才往后执行
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
