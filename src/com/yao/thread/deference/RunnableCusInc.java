package com.yao.thread.deference;


/**
 * 描述： 增加存款
 *
 * @author pengjie_yao
 * @date 2019/8/1 17:22
 */
public class RunnableCusInc implements  Runnable {

    private ShareData shareData;

    public RunnableCusInc(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        // 自增5次
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }
}
