package com.DesignMode.Demo04;


import sun.security.jca.GetInstance;

/**
 * 饿汉式单例模式
 * 类初始化时,会立即加载该类,线程天生安全,调用效率搞
 */
public class SingleModeDemo01 {

    private static SingleModeDemo01 hungryDesignModeDemo01  = new SingleModeDemo01();

    public SingleModeDemo01() {
        System.out.println("饿汉式 初始化类");
    }

    public static SingleModeDemo01 GetInstance(){
        System.out.println("com.DesignMode.Demo04.HungryDesignModeDemo01.GetInstance");
        return  hungryDesignModeDemo01;
    }
}
