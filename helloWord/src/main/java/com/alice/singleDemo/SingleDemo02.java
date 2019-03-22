package com.alice.singleDemo;

/**
 * 静态内部类
 */
public class SingleDemo02 {

    private SingleDemo02() {
    }

    //静态内部类
    public static class classLoad{
        public final static SingleDemo02 singleDemo02 = new SingleDemo02();
    }

    public static SingleDemo02 getInstance(){
        return classLoad.singleDemo02;
    }

}
