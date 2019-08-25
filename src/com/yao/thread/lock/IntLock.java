package com.yao.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述： 可中断锁测试
 *
 * @author pengjie_yao
 * @date 2019/8/6 13:40
 */
public class IntLock implements Runnable {

    int lock;

    /**
     * 控制加锁顺序，方便制造死锁
     * @param lock
     */
    public IntLock(int lock) {
        this.lock = lock;
    }

    /**
     *  公平锁
     */
    static ReentrantLock fairLock =new ReentrantLock(true);

    /**
     *  非公平锁
     */
    static ReentrantLock unfairLock = new ReentrantLock();


    @Override

    public void run() {
        try {
            if (lock == 1) {
                // 如果当前线程未被中断，则获取锁。
                fairLock.lockInterruptibly();// 即在等待锁的过程中，可以响应中断。
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 试图获取 lock 2 的锁
                unfairLock.lockInterruptibly();
            } else {

                unfairLock.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 该线程在企图获取 lock1 的时候，会死锁，但被调用了 thread.interrupt 方法，导致中断。中断会放弃锁。
                fairLock.lockInterruptibly();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (fairLock.isHeldByCurrentThread()) {
                fairLock.unlock();
            }

            // 查询当前线程是否保持此锁。
            if (unfairLock.isHeldByCurrentThread()) {
                unfairLock.unlock();
            }

            System.out.println(Thread.currentThread().getId() + ": 线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * 这部分代码主要是针对 lockInterruptibly 方法，该方法在线程发生死锁的时候可以中断线程。让线程放弃锁。
         * 而 synchronized 是没有这个功能的， 他要么获得锁继续执行，要么继续等待锁。
         */

        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        // 中断其中一个线程（只有线程在等待锁的过程中才有效）
        // 如果线程已经拿到了锁，中断是不起任何作用的。
        // 注意：这点 synchronized 是不能实现此功能的，synchronized 在等待过程中无法中断
        t2.interrupt();
        // t2 线程中断，抛出异常，并放开锁。没有完成任务
        // t1 顺利完成任务。
    }
}
