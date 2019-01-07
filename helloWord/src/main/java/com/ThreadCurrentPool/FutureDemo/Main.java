package com.ThreadCurrentPool.FutureDemo;

/**
 * 需求:使用多线程技术,实现多线程下载,每个线程都会发一个http请求资源,进行下载操作
 *
 *   1.创建多线程,集成Thread类或者实现Runnable接口,run方法执行任务代码,思考run方法的缺点:没有返回值
 *
 *   多线程下载优点:提高效率
 *   实现下载:会有下载进度
 *
 *   应用场景:桌面应用程序(CS),下载一张图片进行展示,使用子线线程进行下载图片,整个应用程序不会阻塞
 *
 *   A和B两个线程,如果A需要B的执行结果,那么这个A线程不需要等待B执行完毕后,才能拿到结果
 *
 *   使用Future模式可以先拿到一个未来的Future,等B有结果时再取出真实的结果
 *   类似于ajax
 */
public class Main {

    public static void main(String[] args) {

        FutureClient futureClient = new FutureClient();
        DataDemo helloworld = futureClient.request("helloworld");
        System.out.println("请求发送成功!!!");
        System.out.println("执行其他任务...");
        String requestStrhelloworld = helloworld.getRequest();
        System.out.println("获取到结果..." + requestStrhelloworld);

    }

}
