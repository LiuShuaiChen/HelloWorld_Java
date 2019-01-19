package com.DesignMode.Demo04;


/**
 * 懒汉式单例模式
 * 类初始化,不会加载该类,当真正需要的时候才会创建该对象
 */
public class SingleModeDemo02 {

    private static SingleModeDemo02 singleModeDemo02;

    public SingleModeDemo02() {
        System.out.println("懒汉式 类加载");
    }

    public static synchronized SingleModeDemo02 getInstance(){
        System.out.println("com.DesignMode.Demo04.SingleModeDemo02.getInstance");
        if (singleModeDemo02 == null){
            singleModeDemo02 = new SingleModeDemo02();
        }
        return singleModeDemo02;
    }
}
