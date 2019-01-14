package com.SemaphoreDemo;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore是一种基于计数的信号量。它可以设定一个阈值，基于此，多个线程竞争获取许可信号，做自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞。Semaphore可以用来构建一些对象池，资源池之类的，
 * 比如数据库连接池，我们也可以创建计数为1的Semaphore，将其作为一种类似互斥锁的机制，这也叫二元信号量，表示两种互斥状态。它的用法如下：
 * availablePermits函数用来获取当前可用的资源数量
 * wc.acquire(); //申请资源
 * wc.release();// 释放资源
 */
public class SemaphoreThread extends Thread {

    private String name;
    private Semaphore semaphore;

    public SemaphoreThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int availablePermits = semaphore.availablePermits();
        if (availablePermits > 0) {
            System.out.println(Thread.currentThread().getName() + " 有位置了");
        } else {
            System.out.println(Thread.currentThread().getName() + " 没有占到位置");
        }

        try {
            //申请资源
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " 申请到资源,剩下的资源为==> " + semaphore.availablePermits());

//        try {
//            Thread.sleep(new Random().nextInt(100));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(name + " 线程 " + Thread.currentThread().getName() +" 资源已经使用完毕!");
        //释放资源
        semaphore.release();


    }
}



class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 100; i++) {
            SemaphoreThread semaphoreThread = new SemaphoreThread(i + " helloworld", semaphore);
            semaphoreThread.start();
        }
    }
}
