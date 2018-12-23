package com.javaMemoryModel;

public class ThreadSafeDemo02 {

    public static void main(String[] args) {
        ThreadTicket demo01 = new ThreadTicket();
        ThreadTicket demo02 = new ThreadTicket();
        ThreadTicket demo03 = new ThreadTicket();

        Thread thread01 = new Thread(demo01, "T1");
        Thread thread02 = new Thread(demo02, "T2");
        Thread thread03 = new Thread(demo03, "T3");

        thread01.start();
        thread02.start();
        thread03.start();
    }

}


class ThreadTicket implements Runnable {

    private static int count = 100;
    private static Object obj = new Object();

    private void buyTicket() {
        synchronized (obj) {
            if (count > 0) {
                try {
                    Thread.sleep(20);
                    System.out.println("火车票窗口==> " + Thread.currentThread().getName() + " 剩余 " + count + " 张票");
                    count = count - 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        while (count > 0) {
            buyTicket();
        }
    }
}