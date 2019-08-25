package com.yao.thread.deference;

/**
 * 描述： 取款
 *
 * @author pengjie_yao
 * @date 2019/8/1 17:24
 */
public class RunnableCusDesc implements Runnable{

    private ShareData shareData;

    public RunnableCusDesc(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        // 自减少5次
        for (int i = 0; i < 5; i++) {
            shareData.desc();
        }
    }
}
