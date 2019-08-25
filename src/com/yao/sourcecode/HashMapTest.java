package com.yao.sourcecode;

import java.util.HashMap;
import java.util.Objects;

/**
 * 描述： HashMap的源码分析
 *
 * @author pengjie_yao
 * @date 2019/7/18 8:32
 */
public class HashMapTest {

    public static void main(String[] args) {

        HashMap<Student, String> map = new HashMap<>(2);
       // 这里key为new一个对象
        map.put( new Student(31,"张三"), "1");
        map.put(new Student(32, "李四"), "2");
        String s = map.get( new Student(31,"张三"));
        System.out.println(s);
    }


    public static class Student {
        /**
         *  年龄
          */
        int age;
        /**
         *  名字
         */
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

}
