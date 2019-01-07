package com.JavaMemoryModelDemo;

/**
 * 睡眠排序
 * 2018-12-27 14:04:18
 */
public class ThreadLocalDemo03 {

    public static void main(String[] args) {
        int arr[] = {5,33,22,66,1,2,10,3,7,22,10};
        for (int i = 0; i < arr.length; i++) {
            ThreadDemo03 demo03 = new ThreadDemo03(arr[i]);
            Thread thread = new Thread(demo03);
            thread.start();
        }
    }
}


class ThreadDemo03 implements Runnable {

    private int num;

    public ThreadDemo03(int num) {
        this.num = num;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(num);
            System.out.println(Thread.currentThread().getName() + " 睡醒 ==>" + num );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}