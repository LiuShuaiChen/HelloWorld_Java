package com.ThreadCurrentPool;

import com.ThreadCurrentPool.FutureDemo.DataDemo;
import com.ThreadCurrentPool.FutureDemo.FutureClient;

/**
 * Future模式
 *
 * 观察者模式的一个实现
 * 利用监听模式做的这个，发送异步以后是开了一个新的线程来监听到响应，监听到以后封装到future对象中，取数据 做处理
 *
 */


public class ThreadPoolDemo07 {

    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        DataDemo helloworld = futureClient.request("helloworld");
        System.out.println("请求发送成功!!!");
        System.out.println("执行其他任务...");
        String requestStrhelloworld = helloworld.getRequest();
        System.out.println("获取到结果..." + requestStrhelloworld);
    }
}
