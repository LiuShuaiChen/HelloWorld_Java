package com.DesignMode.Demo04;

import org.junit.Test;

/**
 * 双重检测锁
 */
public class SingleModeDemo05 {

    private SingleModeDemo05 singleModeDemo05;

    public SingleModeDemo05() {
        System.out.println("双重检测锁 类初始化");
    }

    public SingleModeDemo05 getInstance(){
        if(singleModeDemo05 == null){
            synchronized (this){
                if(singleModeDemo05 == null){
                    singleModeDemo05 = new SingleModeDemo05();
                }
            }
        }
        return singleModeDemo05;
    }

    @Test
    public void test(){
        SingleModeDemo05 instance1 = singleModeDemo05.getInstance();
        SingleModeDemo05 instance2 = singleModeDemo05.getInstance();
        System.out.println(instance1 == instance2);
    }
}

