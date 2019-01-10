package com.ThreadLock;

import com.alice.HelloWord.App;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java锁
 * 悲观锁、乐观锁、排他锁
 * <p>
 * 什么是重入锁?
 * 读写锁 悲观锁和乐观锁 CAS无锁 自旋锁
 * AQS 非公平锁 公平锁
 * 排他锁
 * 分布式锁
 * redis实现分布式所 ZK实现分布式锁
 * <p>
 * <p>
 * 轻量级锁(Lock锁) 与 重量级锁(Synchronized锁) 可重入性(递归锁)
 * 演示 lock锁 是否具备 可重入性 特征,锁可以传递(方法递归传递)
 */
public class LockDemo01 implements Runnable {

    Lock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
//        App.getHelloWorld();
//        CountDownLatch countDownLatch = new CountDownLatch(5);
//        System.out.println(countDownLatch.getCount());

        HashSet<String> list = new HashSet<String>();

        LockDemo01 lockDemo01 = new LockDemo01();
        Thread thread = new Thread(lockDemo01);
        thread.start();

    }

    public void set() {
        try {
            reentrantLock.lock();
            System.out.println("Set方法");
            get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void get() {
        try {
            reentrantLock.lock();
            System.out.println("synchronized 具备 可重入性 Get方法");
//            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public void run() {

        set();
    }
}