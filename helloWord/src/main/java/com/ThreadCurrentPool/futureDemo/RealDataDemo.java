package com.ThreadCurrentPool.futureDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 真实数据RealDataDemo
 */
public class RealDataDemo {
    private String result;

    public RealDataDemo() {
    }

    public String getResult() {
        return result;
    }

    public RealDataDemo(String result) {
        System.out.println("......start " + result);
        AtomicInteger atomicInteger = new AtomicInteger();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(atomicInteger.incrementAndGet());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("......end ");
        this.result = result;
    }
}
