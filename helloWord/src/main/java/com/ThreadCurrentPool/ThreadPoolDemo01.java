package com.ThreadCurrentPool;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Java中的线程池是运用场景最多的并发框架，几乎所有需要异步或并发执行任务的程序
 * 都可以使用线程池。在开发过程中，合理地使用线程池能够带来3个好处。
 * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
 * 第二：提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
 * 第三：提高线程的可管理性。线程是稀缺资源，如果无限制地创建，不仅会消耗系统资源，
 * 还会降低系统的稳定性，使用线程池可以进行统一分配、调优和监控。但是，要做到合理利用
 * 线程池，必须对其实现原理了如指掌。
 *
 * 阻塞队列 与 非阻塞队列
 * 并发队列 ConcurrentLinkedQueue(非阻塞式) BlockingQueue(阻塞式)
 *
 * 阻塞式队列与非阻塞式队列区别
 * 1. 入列 出列(阻塞式)
 *   入列 (存队列) 阻塞式队列 如果超出队列总数 这时会进行等待(阻塞)
 *   出列 (获取队列) 如果获取队列位空的情况下,这时候也会进行等待(阻塞)
 * 队列的概念:主要是遵循 先进先出 后进后出 的原则
 *
 *  阻塞队列最大好处 能够防止队列容器溢出 防止丢失数据
 *
 *
 */
public class ThreadPoolDemo01 {
    public static void main(String[] args) {

        //并发包线程
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
        concurrentLinkedQueue.offer("AA");
        concurrentLinkedQueue.offer("BB");
        concurrentLinkedQueue.offer("CC");

        //获取队列
//        System.out.println(concurrentLinkedQueue.poll());
//        System.out.println(concurrentLinkedQueue.poll());
        //获取队列个数
        System.out.println(concurrentLinkedQueue.size());

        int count = concurrentLinkedQueue.size();
        for (int i = 0; i < count; i++) {
            System.out.println(concurrentLinkedQueue.poll());
        }



//        ConcurrentLinkedDeque<Object> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
//        concurrentLinkedDeque.offer("AA");
//        concurrentLinkedDeque.offer("BB");
//        concurrentLinkedDeque.offer("CC");
//        //获取队列
//        System.out.println(concurrentLinkedDeque.poll());
//        //获取队列个数
//        System.out.println(concurrentLinkedDeque.size());


    }
}
