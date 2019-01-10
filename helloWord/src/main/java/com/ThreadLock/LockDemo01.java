package com.ThreadLock;

import com.alice.HelloWord.App;

import java.util.concurrent.CountDownLatch;

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
 */
public class LockDemo01 implements Runnable {

    public static void main(String[] args) {
//        App.getHelloWorld();
//        CountDownLatch countDownLatch = new CountDownLatch(5);
//        System.out.println(countDownLatch.getCount());

        LockDemo01 lockDemo01 = new LockDemo01();
        Thread thread = new Thread(lockDemo01);
        thread.start();

    }

    public synchronized void set() {
        System.out.println("Set方法");
        get();
    }

    public synchronized void get() {
        System.out.println("synchronized 具备 可重入性 Get方法");
        set();
    }

    @Override
    public void run() {

        set();
    }
}