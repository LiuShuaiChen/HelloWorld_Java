package com.FacadePattern;

/**
 * 外观模式Facade Pattern
 * 也叫作门面模式
 *
 * 隐藏系统的复杂性 并向客户端提供了一个客户端可以访问系统的接口
 * 这种类型的设计模式属于结构型模式，它向现有的系统添加一个接口，来隐藏系统的复杂性。
 * 这种模式涉及到一个单一的类，该类提供了客户端请求的简化方法和对现有系统类方法的委托调用。
 *
 */
public class HelloWorld {

    public static void main(String[] args) {
        new Computer().sendMsg();
    }
}
