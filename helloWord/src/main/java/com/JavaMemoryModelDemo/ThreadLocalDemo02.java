package com.JavaMemoryModelDemo;

/**
 * volatile关键字
 * 2018-12-27 14:45:07
 */
public class ThreadLocalDemo02 {

    public static void main(String[] args) {
        try {
            ThreadDemo02 threadDemo02 = new ThreadDemo02();
            threadDemo02.start();
            Thread.sleep(3000);
            threadDemo02.setRunning(false);
            System.out.println("flag已经改成false");
            Thread.sleep(3000);
            System.out.println("flag==> " + threadDemo02.flag);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadDemo02 extends Thread {

    public volatile boolean flag = true;
    public void setRunning(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("线程开始..............");
        int i= 0;
        while (flag) {
            i = ++i;
            System.out.println("i==>" + i);
        }
        System.out.println("线程结束..............");
    }

}