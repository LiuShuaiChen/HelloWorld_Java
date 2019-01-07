package com.ThreadCurrentPool.FutureDemo;

public class FutureDataDemo implements DataDemo {

    private RealDataDemo realDataDemo;
    public volatile static boolean isFlag = false;

    public synchronized void setRealDataDemo(RealDataDemo realDataDemo) {

        //如果获取到结果 直接返回
        if (isFlag) {
            return;
        }

        //如果没有获取到数据,传递真实对象
        this.realDataDemo = realDataDemo;
        isFlag = true;
        //唤醒线程
        notify();
    }

    @Override
    public synchronized String getRequest() {

        while (!isFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return realDataDemo.getResult();
    }
}
