package com.DisruptorDemo;

import com.lmax.disruptor.EventFactory;

/**
 * 工厂模式 实例化对象
 */
public class LongEvent_Factory implements EventFactory<LongEvent_Bean> {

    @Override
    public LongEvent_Bean newInstance() {
        return new LongEvent_Bean();
    }
}
