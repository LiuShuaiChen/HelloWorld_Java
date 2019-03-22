package com.alice.singleDemo;

public class SingleDemo01 {

    private static SingleDemo01 singleDemo01;

    private SingleDemo01(){
    }

    public static SingleDemo01 getInstance(){
        if (singleDemo01 == null) {
            synchronized (SingleDemo01.class){
                if (singleDemo01 == null){
                    singleDemo01 = new SingleDemo01();
                }
            }
        }
        return singleDemo01;
    }
}
