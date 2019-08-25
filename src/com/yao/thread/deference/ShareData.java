package com.yao.thread.deference;

/**
 * 描述： 共享变量
 *
 * @author pengjie_yao
 * @date 2019/8/1 17:17
 */
public class ShareData {
    /**
     *  初始的金额为10
     */
    private int num = 10;

    /**
     * 增加
     */
    public synchronized void inc() {
        num++;
        System.out.println("当前线程：" + Thread.currentThread().getName() + "--------存款后的余额为：" + num);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  减少
     */
    public synchronized  void desc(){
        num--;
        System.out.println("当前线程：" + Thread.currentThread().getName() + "--------取款后的余额为" + num);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
