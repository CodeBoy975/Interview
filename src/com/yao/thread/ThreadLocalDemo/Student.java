package com.yao.thread.ThreadLocalDemo;

/**
 * 描述： 学生
 *
 * @author pengjie_yao
 * @date 2019/8/1 16:09
 */
public class Student {
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
