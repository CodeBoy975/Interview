package com.yao.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述： 线程池
 *
 * @author pengjie_yao
 * @date 2019/7/16 14:08
 */
public class UserThreadPool {
    public static void main(String[] args) {
        // 缓存队列设置固定长度为2，为了快速触发rejectHandler
        BlockingQueue queue = new LinkedBlockingDeque(10);
        // 假设外部任务线程的来源由机房1和机房2的混合调用
        UserThreadFatory userThreadFatory1 = new UserThreadFatory("第1机房");
        UserThreadFatory userThreadFatory2 = new UserThreadFatory("第2机房");

        UserRejectHandler handler = new UserRejectHandler();

        // 核心线程为1，最大线程为2， 为了保证触发rejectHandler
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, queue, userThreadFatory1, handler);
        // 利用第二个线程工厂实例创建第二个线程池
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, queue, userThreadFatory2, handler);

        // 创建400个任务线程
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}
