package com.FactoryMode.Demo01;

public class HelloWorld {
    public static void main(String[] args) {

        Car aodi = CarFactory.getCar("奥迪");
        aodi.run();

        Car bmp = CarFactory.getCar("宝马");
        bmp.run();

//        Car anull = CarFactory.getCar("null");
//        anull.run();


    }
}
