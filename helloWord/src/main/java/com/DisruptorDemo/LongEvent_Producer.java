package com.DisruptorDemo;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class LongEvent_Producer {

    public final RingBuffer<LongEvent_Bean> ringBuffer;


    public LongEvent_Producer(RingBuffer<LongEvent_Bean> ringBuffer) {
        this.ringBuffer = ringBuffer;

    }

    public void onData(ByteBuffer byteBuffer) {
        //ringBuffer 事件队列
        long sequence = ringBuffer.next();
        Long date = null;

        try {
            LongEvent_Bean longEvent = ringBuffer.get(sequence);
            date = byteBuffer.getLong(0);
            //获取消息队列传递的数据
            longEvent.setValue(date);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }finally {
            System.out.println("生产者准备发送数据 " + sequence);
            //发布事件
            ringBuffer.publish(sequence);
        }
    }
}
