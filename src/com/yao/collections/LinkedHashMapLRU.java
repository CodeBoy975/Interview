package com.yao.collections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 *   该类是线程安全的带有容量限制的LinkedHashMap
 *   超容量的元素采用LRU方式删除
 *   线程安全仅限于已经覆盖的几个方法，若有其他需要可自行添加
 *   迭代操作不保证数据的一致性，即使remove方法是线程安全的也会抛ConcurrentModificationException
 *
 *
 * @author pengjie_yao
 * @date 2019/7/16 18:25
 */
public class LinkedHashMapLRU<K,V> extends LinkedHashMap<K,V> {

    private static final long serialVersionUID = -7911712053305433954L;

    private int capacity;
    private final ReentrantLock lock = new ReentrantLock();

    public LinkedHashMapLRU(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }
    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }
    @Override
    public V remove(Object key) {
        try {
            lock.lock();
            return super.remove(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if(size() > capacity) {
            System.out.println(eldest.getKey() +":" + eldest.getValue());
            return true;
        }
        return false;
    }

    public void setMaxSize(int size) {
        this.capacity = size;
    }
}
