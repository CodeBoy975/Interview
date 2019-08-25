package com.yao.thread.pool;

/**
 * 描述： 实现runnable接口
 *
 * @author pengjie_yao
 * @date 2019/8/5 7:38
 */
public class MyThread extends  Thread {

    @Override
    public void run() {
        System.out.println("当前正在运行的线程名为：" + Thread.currentThread().getName());
    }


}
