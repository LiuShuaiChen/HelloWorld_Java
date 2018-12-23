package com.javaMemoryModel;

/**
 * 线程安全 守护线程
 * 2018-12-23 12:29:20
 */
public class ThreadSafeDemo01 {
    public static void main(String[] args) {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();

        Thread thread01 = new Thread(threadDemo01);
        thread01.setName("T1");

        Thread thread02 = new Thread(threadDemo01);
        thread02.setName("T2");

        Thread thread03 = new Thread(threadDemo01);
        thread03.setName("T3");

        thread01.start();
        thread02.start();
        thread03.start();
    }

}


class ThreadDemo01 implements Runnable {
    private int count = 10000000;

    public synchronized void buyTicket() {
        if (count > 0) {
            System.out.println("火车票窗口==> " + Thread.currentThread().getName() + " 剩余" + count + " 张票");
            --count;
        }
    }

    @Override
    public void run() {
        while (count > 0) {
            buyTicket();
        }
    }


}