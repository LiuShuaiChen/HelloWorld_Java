package com.AdapterPatternModel;

public class CN220VInterfaceImpl implements CN220VInterface {
    @Override
    public void connect() {
        System.out.println("中国电压220V开始连接...");
    }
}
