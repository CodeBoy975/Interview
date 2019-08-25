package com.yao.thread.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 描述： 优先阻塞队列测试
 *
 * @author pengjie_yao
 * @date 2019/8/5 16:07
 */
public class PriorityBlockingQueueDemo {


    public static PriorityBlockingQueue<User> priorityBlockingQueue = new PriorityBlockingQueue<User>();

    public static void main(String[] args) throws InterruptedException {

        priorityBlockingQueue.add(new User(1, "张三"));
        priorityBlockingQueue.add(new User(2, "李四"));
        priorityBlockingQueue.add(new User(3, "王五"));

        // 遍历
        for (User user : priorityBlockingQueue) {
            System.out.println(priorityBlockingQueue.take().name);

        }


    }

    public static class User implements Comparable<User> {

        /**
         * 年龄
         */
        int age;
        /**
         * 姓名
         */
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        /**
         *  实现自定义比较器
         * @param o
         * @return
         */
        @Override
        public int compareTo(User o) {
            return this.age > o.age ? -1 : 1;
        }
    }

}
