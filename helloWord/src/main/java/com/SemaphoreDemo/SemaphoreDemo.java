package com.SemaphoreDemo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 100; i++) {
            SemaphoreThread semaphoreThread = new SemaphoreThread(i + " helloworld", semaphore);
            semaphoreThread.start();
        }
    }
}
