package com.ThreadLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2019-1-10 19:04:25
 * 悲观锁
 * CAS 解决SSO单点登录
 * <p>
 * 总是假设最坏的情况，每次取数据时都认为其他线程会修改，所以都会加锁（读锁、写锁、行锁等），当其他线程想要访问数据时，都需要阻塞挂起。
 * 可以依靠数据库实现，如行锁、读锁和写锁等，都是在操作之前加锁，
 * 在Java中，synchronized的思想也是悲观锁。
 * <p>
 * 悲观锁的特征
 * 属于重量级锁,会阻塞 会进行等待
 */
public class LockDemo03 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("HelloWorld");
            }
        }).start();


        LockDemoEnity004 lockDemoEnity01 = new LockDemoEnity004();
        LockDemoEnity004 lockDemoEnity02 = new LockDemoEnity004();

        new Thread(lockDemoEnity01).start();
        new Thread(lockDemoEnity02).start();

//        CAS 无锁原理
//        do{
//            备份旧数据；
//            基于旧数据构造新数据；
//        }while(!CAS( 内存地址，备份的旧数据，新数据 ))


    }
}

/**
 * AtomicInteger原子类
 * 原子类线程安全 非阻塞 本质底层没有使用锁
 * 原子类底层实现原理CAS无锁技术 (比较再交换)
 * CAS Compare And Swap
 *
 *
 * CAS(乐观锁算法)
 *
 * 但是CAS存在一个问题:即ABA问题
 * 问题:如果变量V初次读取的时候是A,那么CAS操作就会误认为它从来没有修改过.
 * 针对这种情况,Java的并发包中提供了一个带有标识的原子引用类AtomicStampedReference,它可以通过控制变量值的版本来保证CAS的正确性.
 *
 * 原子引用类AtomicStampedReference
 */
class LockDemoEnity004 implements Runnable {

    private static int COUNT = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            int x = getInt();
            if (x <= 50) {
                System.out.println(x);
            } else {
                break;
            }
        }
    }

    public int getInt() {

        //两个不同的对象 读的时候 也会产生线程安全问题
        synchronized (LockDemoEnity004.class) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return COUNT++;
        }
    }

    //原子性
    public Integer getAtomicInteger() {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return atomicInteger.incrementAndGet();
    }
}