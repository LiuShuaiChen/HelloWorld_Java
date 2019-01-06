package com.ThreadCurrentPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2019-1-6 11:25:03
 * 合理配置线程池
 * 原则:CPU密集 IO密集
 * <p>
 * <p>
 * 异步请求模式
 *
 * Future模式的核心在于：去除了主函数的等待时间，并使得原本需要等待的时间段可以用于处理其他业务逻辑
 *
 * 创建多线程:继承Thread类或者实现Runnable接口,run方法执行任务代码
 *  但是run方法的缺点是没有返回值;不能抛异常
 */

class testDemo05 implements Runnable {

    public testDemo05() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" 随机数生成==> " + i + (int) (Math.random() * 11));
            //特别多的代码...没有阻塞的情况下
            //阻塞的情况产生的原因有:请求 读数据库 循环
            //假如这里请求  http.post()...阻塞2秒
            //io密集,该任务需要大量的IO操作,产生阻塞,如果是单线程中执行阻塞,可以去使用多线程技术(异步).

            //如果在IO密集的情况下 cpu运行能力,不会浪费等待资源.
            //如果是IO密集的情况,就需要多配置线程数 => 2*CPU的核数
            //解决阻塞的情况下,可以使用多线程技术

            //CPU密集:该任务(run任务)需要大量的运算,而且没有阻塞,CPU会全速运行
            //CPU密集:该任务的时候,不会产生大量的IO阻塞,CPU运行的时候特别快
            //如果是CPU密集的情况下,配置线程数=CPU的核数


        }

    }
}


public class ThreadPoolDemo05 {

    public static void main(String[] args) {

        testDemo05 testDemo05 = new testDemo05();

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool.submit(testDemo05);

        newCachedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("HelloWorld");
                }
            }
        });

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("HelloWorld111111");
            }
        });

        //关闭线程池
        newCachedThreadPool.shutdown();
        newFixedThreadPool.shutdown();
    }
}
