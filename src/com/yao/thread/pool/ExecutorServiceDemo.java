package com.yao.thread.pool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 描述： ExecutorService执行器的demo
 *
 * @author pengjie_yao
 * @date 2019/8/5 7:56
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService =  Executors.newFixedThreadPool(3);

        /**
         *  第一种方式
         */
       /* executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个线程任务");
            }
        });*/

        /**
         *  第二种:submit
         */
        /*Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个线程任务");
            }
        });*/
        /**
         *  第三种: Callable: future保留返回的结果
         */
       /* Future future1 = executorService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                return "Callable result";
            }
        });*/

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 1";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 2";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 3";
            }
        });
//        String result = executorService.invokeAny(callables);
//        System.out.println(result);

        List<Future<String>> futures = executorService.invokeAll(callables);

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        // 线程关闭
//        executorService.shutdown();
    }
}
