package com.alice.singleDemo;

public class SingleDemo03 {

    private final static SingleDemo03 SINGLE_DEMO_03 = new SingleDemo03();

    private SingleDemo03(){
    }


    public static SingleDemo03 getInstance(){
        return SINGLE_DEMO_03;
    }
}
