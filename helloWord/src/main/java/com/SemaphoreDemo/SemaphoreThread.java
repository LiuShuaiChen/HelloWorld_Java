package com.SemaphoreDemo;

import java.util.Random;
import java.util.concurrent.Semaphore;

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

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " 线程 " + Thread.currentThread().getName() +" 资源已经使用完毕!");
        //释放资源
        semaphore.release();


    }
}
