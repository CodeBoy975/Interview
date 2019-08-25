package com.yao.thread.sharkeThread;

import com.yao.thread.ThreadLocalDemo.ThreadLocalTest;

/**
 * 描述： 共享数据
 *
 * @author pengjie_yao
 * @date 2019/8/1 17:06
 */
public class ShareData {

    private int num = 0;

    public synchronized void inc() {
        num++;
        System.out.println("卖出票数为："+num);
        System.out.println("当前线程为：" + Thread.currentThread().getName() + "当前num值为" + num);
        try {
            // 让该线程休眠1000毫秒
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
