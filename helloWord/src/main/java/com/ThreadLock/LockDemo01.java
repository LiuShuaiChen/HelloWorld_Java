package com.ThreadLock;

import com.alice.HelloWord.App;

import java.util.concurrent.CountDownLatch;

public class LockDemo01 {

    public static void main(String[] args) {
        App.getHelloWorld();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println(countDownLatch.getCount());

        countDownLatch.countDown();
    }
}
