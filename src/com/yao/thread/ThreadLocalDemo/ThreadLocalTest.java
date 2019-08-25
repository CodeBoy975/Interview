package com.yao.thread.ThreadLocalDemo;

import java.util.Random;

/**
 * 描述： 本地线程测试
 *
 * @author pengjie_yao
 * @date 2019/8/1 16:08
 */
public class ThreadLocalTest implements Runnable {

    ThreadLocal<Student> studentThreadLocal = new ThreadLocal<Student>();

    @Override
    public void run() {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("当前线程" + currentThreadName + "正在运行");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("当前线程" + currentThreadName + "设置学生年龄为" + age);
        // 通过该方法，为每个线程都独立设置一个new一个student对象，每个对象都可以设置为不同的值，互不影响；
        Student student = getStudent();
        student.setAge(age);
        System.out.println("当前线程" + currentThreadName + "学生年龄获取为" + student.getAge());
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("当前线程：" + currentThreadName + "第二个获取年龄为" + student.getAge());
    }

    /**
     * 步骤：
     * 1. 从ThreadLocal获取对象
     * 2. 如果ThreadLocal没有，则创建新对象放入ThreadLocal中
     *
     * @return
     */
    private Student getStudent() {
        // 1. 从ThreadLocal获取对象
        Student student = studentThreadLocal.get();
        // 2. 如果ThreadLocal没有，则创建新对象放入ThreadLocal中
        if (student == null) {
            student = new Student();
            studentThreadLocal.set(student);

        }
        return student;
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        Thread thread = new Thread(threadLocalTest, "ThreadA");
        Thread thread1 = new Thread(threadLocalTest, "ThreadB");
        thread.start();
        thread1.start();

    }
}
