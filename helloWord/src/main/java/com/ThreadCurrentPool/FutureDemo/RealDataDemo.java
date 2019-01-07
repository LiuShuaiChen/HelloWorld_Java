package com.ThreadCurrentPool.FutureDemo;

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
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                System.out.print(atomicInteger.incrementAndGet());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("......end ");
        this.result = result;
    }
}
