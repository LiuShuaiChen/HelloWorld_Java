package com.AdapterPatternModel;

public class JP110VInterfaceImpl implements JP110VInterface {
    @Override
    public void connect() {
        System.out.println("日本110V电压开始连接...");
    }
}
