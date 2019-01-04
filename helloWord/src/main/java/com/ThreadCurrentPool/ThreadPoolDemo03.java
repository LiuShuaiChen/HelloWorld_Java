package com.ThreadCurrentPool;

import java.sql.Time;
import java.util.ArrayDeque;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用BlockingQueue模拟生产者消费者
 * <p>
 * 队列: 遵循先进先出 后进后出的原则
 * <p>
 * 注意: 当消费者获取队列之后 这个数据会被直接删除
 */

/**
 * ArrayBlockingQueue 底层是数组，有界队列，如果我们要使用生产者-消费者模式，这是非常好的选择。
 * LinkedBlockingQueue 底层是链表，可以当做无界和有界队列来使用，所以大家不要以为它就是无界队列。
 * SynchronousQueue 本身不带有空间来存储任何元素，使用上可以选择公平模式和非公平模式。
 * PriorityBlockingQueue 是无界队列，基于数组，数据结构为二叉堆，数组第一个也是树的根节点总是最小值。
 */


// 生产者队列
class ProducerThread implements Runnable {

    private BlockingQueue<String> blockingQueue;

    // 要注意 禁止重排序!!!
    private volatile boolean flag = true;

    private AtomicInteger atomicInteger;

    public ProducerThread() {
    }

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("###生产者线程已经启动###");
        atomicInteger = new AtomicInteger();
        while (flag) {
            try {
                String str = atomicInteger.incrementAndGet() + "";
                boolean offer = blockingQueue.offer(str, 3, TimeUnit.SECONDS);
                if (!offer) {
                    System.err.println("生产者存入队列失败! data=>" + str);
                } else {
                    System.out.println("生产者存入队列成功! data=>" + str);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产者已经结束......");
    }

    public void stop() {
        this.flag = false;
    }
}

// 消费者线程
class ConsumerThread implements Runnable {

    private BlockingQueue<String> blockingQueue;

    private volatile boolean flag = true;

    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public ConsumerThread() {
    }

    @Override
    public void run() {

        System.out.println("###消费者线程已经启动###");

        while (flag) {
            try {
                String str = blockingQueue.poll(3, TimeUnit.SECONDS);
                if (str != null) {
                    System.out.println(str);
                }else {
                    System.err.println("超过3秒时间 没有获取到队列信息...");
                    this.flag = false;
                }

                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.flag = false;
    }
}

/**
 * ArrayBlockingQueue 底层是数组，有界队列，如果我们要使用生产者-消费者模式，这是非常好的选择。
 * LinkedBlockingQueue 底层是链表，可以当做无界和有界队列来使用，所以大家不要以为它就是无界队列。
 * SynchronousQueue 本身不带有空间来存储任何元素，使用上可以选择公平模式和非公平模式。
 * PriorityBlockingQueue 是无界队列，基于数组，数据结构为二叉堆，数组第一个也是树的根节点总是最小值。
 */
public class ThreadPoolDemo03{

    public static void main(String[] args) {

        // ArrayBlockingQueue 是 BlockingQueue 接口的有界队列实现类，底层采用数组来实现。
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
        // 底层基于单向链表实现的阻塞队列，可以当做无界队列也可以当做有界队列来使用
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        // 同步的队列
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        // 带排序的 BlockingQueue 实现，其并发控制采用的是 ReentrantLock，队列为无界队列（ArrayBlockingQueue 是有界队列，
        // LinkedBlockingQueue 也可以通过在构造函数中传入 capacity 指定队列最大的容量，
        // 但是 PriorityBlockingQueue 只能指定初始的队列大小，后面插入元素的时候，如果空间不够的话会自动扩容）。
        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();

        ProducerThread producerThread = new ProducerThread(arrayBlockingQueue);
        Thread threadProducer = new Thread(producerThread);
        threadProducer.start();

        ConsumerThread consumerThread = new ConsumerThread(arrayBlockingQueue);
        Thread threadconsumer = new Thread(consumerThread);
        threadconsumer.start();



//        AtomicInteger atomicInteger = new AtomicInteger();
//        System.out.println(atomicInteger.incrementAndGet());
//        System.out.println(atomicInteger.incrementAndGet());
//        System.out.println(atomicInteger.incrementAndGet());
//        System.out.println(atomicInteger.incrementAndGet());
//        System.out.println(atomicInteger.incrementAndGet());
//        System.out.println(atomicInteger.incrementAndGet());


    }
}


