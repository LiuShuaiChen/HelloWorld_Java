package com.ThreadLock;


import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * ReentrantReadWriteLock读写锁
 * <p>
 * 相比Java中锁(Locks in Java)里Lock实现,读写锁更复杂一些.
 * 假设你的程序中涉及到对一些共享资源的读和写操作,且写操作没有读操作那么的频繁.在没有写操作的时候,两个线程同时读一个资源没有任何问题,所以应该允许多个线程能在同时读取共享资源.
 * 但是如果有一个线程想去写这些共享资源,就不应该再有其它线程对该资源进行读或写
 * <p>
 * 读写分离 -- 读写分离
 * 读锁(获取该值信息)和写锁(对该值做操作)
 * wait notify
 * <p>
 * 类似JVM内置缓存
 */
public class LockDemo02 {

    private volatile HashMap<String, String> cache = new HashMap<String, String>();

    //读写锁
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    Lock rlock = reentrantReadWriteLock.readLock();
    Lock wlock = reentrantReadWriteLock.writeLock();


    //写入元素 synchronized 是什么时候释放锁? 避免死锁
    public void set(String key, String value) {

        try {
            wlock.lock();
            System.out.println("写入方法 key:" + key + ", value:" + value);
            Thread.currentThread().sleep(50);
            cache.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            wlock.unlock();
        }
    }

    //读取元素
    public void get(String key) {

        try {
            rlock.lock();
            Thread.currentThread().sleep(30);
            System.out.println("要读取的key是" + key + " ,得到的value为 " + cache.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rlock.unlock();
        }

    }


    public static void main(String[] args) {

        LockDemo02 lockDemo02 = new LockDemo02();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lockDemo02.set(i + "", i + " aa");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lockDemo02.get(i + "");
                }
            }
        }).start();

    }

}