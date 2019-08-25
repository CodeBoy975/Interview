package com.yao.thread.deference;


/**
 * 描述： 测试
 *
 * @author pengjie_yao
 * @date 2019/8/1 17:25
 */
public class RunnableTest {

    public static void main(String[] args) {

        ShareData shareData = new ShareData();
       /* for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(new com.yao.thread.deference.RunnableCusToInc(shareData), "Thread" + i).start();
            }else {
                new Thread(new RunnableCusDesc(shareData), "Thread" + i).start();
            }
        }*/

        /**
         *  解法2： 内部类的方式
         */
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                // 执行存款
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            shareData.inc();
                        }
                    }
                }, "Thread" + i).start();
            } else {
                // 执行取款
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            shareData.desc();
                        }
                    }
                }, "Thread" + i).start();
            }

        }
    }
}
