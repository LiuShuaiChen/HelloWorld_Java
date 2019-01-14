package com.DisruptorDemo;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并发编程队列
 * Disruptor是一个高性能的异步处理框架 可以认为是最快的消息框架(轻量的JMS)
 * 也可以认为是一个观察者模式的实现,或者事件监听模式的实现.
 * <p>
 * Disruptor使用观察者模式,主动将消息发送给消费者,而不是等消费者从队列中取;在无锁的情况下,实现queue(环形,RingBuffer)的并发操作,性能元高于BlockingQueue
 * <p>
 * <p>
 * 互斥锁和自旋锁的区别
 * 互斥锁：线程会从sleep（加锁）——>running（解锁），过程中有上下文的切换，cpu的抢占，信号的发送等开销。
 * 自旋锁：线程一直是running(加锁——>解锁)，死循环检测锁的标志位，机制不复杂。
 * <p>
 * 关于AQS的了解
 * AQS-Lock
 * 公平锁与非公平锁的区别
 * 公平锁:按顺序执行 先到先拿到锁.
 * 非公平锁:不排队直接拿锁,失败再说.
 * <p>
 * 公平和非公平锁的队列都是基于锁内部维护的一个双向链表,表节点Node的值就是每一个请求当前锁的线程.公平锁则在于每次都是依次从队首取值
 * 锁的实现方式是基于如下几点:
 * 表节点Node和状态state的volatile关键字
 * 非公平锁:
 * 在等待锁的过程中,如果有任意新的线程妄图获取锁,都是有很大的几率直接获取到锁的.
 * <p>
 * Disruptor通过以下设计来解决队列速度慢的问题：
 * 环形数组结构
 * 为了避免垃圾回收，采用数组而非链表。同时，数组对处理器的缓存机制更加友好。
 * 元素位置定位
 * 数组长度2^n，通过位运算，加快定位的速度。下标采取递增的形式。不用担心index溢出的问题。index是long类型，即使100万QPS的处理速度，也需要30万年才能用完。
 * 无锁设计
 * 每个生产者或者消费者线程，会先申请可以操作的元素在数组中的位置，申请到之后，直接在该位置写入或者读取数据。
 * 下面忽略数组的环形结构，介绍一下如何实现无锁设计。整个过程通过原子变量CAS，保证操作的线程安全。
 * <p>
 * Disruptor高性能队列 无锁机制 底层CAS基于事件驱动源
 * BlockingQueue阻塞队列底层使用锁.生产者 队列容器 消费者
 * RingBuffer 环形数组
 * Sequence 序列
 */

public class DisruptorDemo {

    public static void main(String[] args) {

        //1.创建一个可以缓存的线程池 提供给consumer
        ExecutorService executorService = Executors.newCachedThreadPool();

        //2.创建工厂
        EventFactory<LongEvent_Bean> longEvent_factory = new LongEvent_Factory();

        //3.创建ringbuffer大小 2的N次方
        int ringBufferSize = 1024 * 1024;

        //4.创建Disruptor
        Disruptor<LongEvent_Bean> longEvent_beanDisruptor = new Disruptor<LongEvent_Bean>(longEvent_factory, ringBufferSize,
                executorService, ProducerType.SINGLE, new YieldingWaitStrategy());

        //5.连接消费者的方法
        // *如果写两个消费者 则代表一个生产者数据将会被消费两次
        longEvent_beanDisruptor.handleEventsWith(new LongEventHandler1_Consumer());
//        longEvent_beanDisruptor.handleEventsWith(new LongEventHandler2_Consumer());


        //6.启动
        longEvent_beanDisruptor.start();

        //7.创建RingBuffer容器
        RingBuffer<LongEvent_Bean> ringBuffer = longEvent_beanDisruptor.getRingBuffer();

        //8.创建生产者
        LongEvent_Producer longEvent_producer = new LongEvent_Producer(ringBuffer);

        //9.指定缓冲器大小 容量是8
        ByteBuffer allocate = ByteBuffer.allocate(8);
        for (int i = 0; i <= 100; i++) {
            allocate.putLong(0,i);
            longEvent_producer.onData(allocate);
        }

        //10.关闭Disruptor和executorService
        executorService.shutdown();
        longEvent_beanDisruptor.shutdown();


        //环形数组
//        RingBuffer<String> ringBuffer = new RingBuffer<String>();


    }
}
