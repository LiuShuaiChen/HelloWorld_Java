package com.DisruptorDemo;

import com.lmax.disruptor.EventHandler;

/**
 * 消费者获取生产者推送的数据
 */
public class LongEventHandler1_Consumer implements EventHandler<LongEvent_Bean> {

    @Override
    public void onEvent(LongEvent_Bean longEvent, long l, boolean b) throws Exception {
        System.out.println("消费者获取生产者数据 event1 " + longEvent.getValue() );
    }
}
