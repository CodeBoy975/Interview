package com.yao.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 描述： 拒绝策略
 *
 * @author pengjie_yao
 * @date 2019/7/16 14:07
 */
public class UserRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected." + executor.toString());
    }
}
