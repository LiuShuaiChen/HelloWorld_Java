package com.ThreadCurrentPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * Java中的线程池是运用场景最多的并发框架，几乎所有需要异步或并发执行任务的程序
 * 都可以使用线程池。在开发过程中，合理地使用线程池能够带来3个好处。
 * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
 * 第二：提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
 * 第三：提高线程的可管理性。线程是稀缺资源，如果无限制地创建，不仅会消耗系统资源，
 * 还会降低系统的稳定性，使用线程池可以进行统一分配、调优和监控。但是，要做到合理利用
 * 线程池，必须对其实现原理了如指掌。
 * <p>
 * 阻塞队列 与 非阻塞队列
 * 并发队列 ConcurrentLinkedQueue(非阻塞式) BlockingQueue(阻塞式)
 * <p>
 * 阻塞式队列与非阻塞式队列区别
 * 1. 入列 出列(阻塞式)
 * 入列 (存队列) 阻塞式队列 如果超出队列总数 这时会进行等待(阻塞)
 * 出列 (获取队列) 如果获取队列位空的情况下,这时候也会进行等待(阻塞)
 * 队列的概念:主要是遵循 先进先出 后进后出 的原则
 * <p>
 * 阻塞队列最大好处 能够防止队列容器溢出 防止丢失数据
 */
public class ThreadPoolDemo02 {

    public static void main(String[] args) {

        // 参数:表示最多队列总数是3个
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        // 最多支持3队列总数 阻塞式队列

        try {
            // 添加非阻塞式队列
            arrayBlockingQueue.offer("AA");
            // 添加阻塞式队列
            arrayBlockingQueue.offer("BB", 3, TimeUnit.SECONDS);
            arrayBlockingQueue.offer("CC");

            // 添加阻塞式队列  超过队列最大总数3  这个队列数据不能放进队列  数据会被丢失
            arrayBlockingQueue.offer("DD", 3, TimeUnit.SECONDS);

            System.out.println(arrayBlockingQueue.poll());
            System.out.println(arrayBlockingQueue.poll());
            System.out.println(arrayBlockingQueue.poll());
            System.out.println(arrayBlockingQueue.poll(4, TimeUnit.SECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(arrayBlockingQueue.size());

        //队列个数是个变量 会随着的数量会被减少
//        int count = arrayBlockingQueue.size();
//        for (int i = 0; i < 4; i++) {
//            System.out.println(arrayBlockingQueue.poll());
//        }

        arrayBlockingQueue.offer("FF");
        System.out.println(arrayBlockingQueue.poll());

    }
}
