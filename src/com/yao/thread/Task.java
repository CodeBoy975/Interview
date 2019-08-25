package com.yao.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 描述： 任务执行体
 *
 * @author pengjie_yao
 * @date 2019/7/16 14:05
 */
public class Task implements Runnable {

    private final AtomicLong count = new AtomicLong(0L);
    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}
