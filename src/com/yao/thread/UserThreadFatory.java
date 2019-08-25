package com.yao.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述： 自定义线程池
 *
 * @author pengjie_yao
 * @date 2019/7/16 13:54
 */
public class UserThreadFatory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    UserThreadFatory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's" + whatFeatureOfGroup + "-Worker";
    }
    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name);
        System.out.println(thread.getName());
        return thread;
    }
}
