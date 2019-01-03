package com.ThreadCommunication;

/**
 * synchronized与volatile的区别
 *
 * volatile保证可见性  但是不能保证原子性 (线程安全问题 禁止重排序)
 *
 * synchrond 既可以保证原子性 也可以保证可见性
 *
 * 重排序概念:CPU会对代码实现执行优化,不会对有依赖关系性做重排序
 * 代码执行的顺序可能会发生改变  但是执行结果不会发生任何的改变
 *
 * 多线程
 *  什么是数据依赖性关系
 *
 * wait与notify的区别
 * wait 等待
 * notify 唤醒
 * 一定要在synchronized执行 持有同一把锁
 */
public class JavaMemmoryReorder {

    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }

}
