package com.alice.singleDemo;

public class Test {

    public static void main(String[] args) {
        SingleDemo02 singleDemo02 = SingleDemo02.getInstance();
        SingleDemo02 singleDemo03 = SingleDemo02.getInstance();

        // 构造方法被private
//        SingleDemo02 singleDemo022 = new SingleDemo02();

        System.out.println(singleDemo02 == singleDemo03);

        SingleDemo01 singleDemo011 = SingleDemo01.getInstance();
        SingleDemo01 singleDemo021 = SingleDemo01.getInstance();

        System.out.println(singleDemo011 == singleDemo021);


//        SingleDemo03 singleDemo031 = new SingleDemo03();
        SingleDemo03 singleDemo032 = SingleDemo03.getInstance();

//        System.out.println(singleDemo031 == singleDemo032);

        System.out.println(2<<31);


    }
}
