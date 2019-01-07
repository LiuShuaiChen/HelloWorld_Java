package com.ThreadCurrentPool;

import com.ThreadCurrentPool.FutureDemo.DataDemo;
import com.ThreadCurrentPool.FutureDemo.FutureClient;

/**
 * Future模式
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
