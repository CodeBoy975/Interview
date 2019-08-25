package com.yao.thread.deference;

/**
 * 描述： 多线程类
 *
 * @author pengjie_yao
 * @date 2019/8/1 17:09
 */
public class RunnableCusToInc implements Runnable {
    /**
     * 共享变量
     */
    private ShareData shareData;

    public RunnableCusToInc(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        for (int i = 0; i < 4; i++) {
            new Thread(new RunnableCusToInc(shareData), "Thread" + i).start();
        }
    }
}