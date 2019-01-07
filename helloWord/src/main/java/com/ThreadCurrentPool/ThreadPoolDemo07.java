package com.ThreadCurrentPool;

/**
 * Future模式
 */

interface DataDemo007 {

    public abstract String getRuques();
}

class RealDataDemo007 implements DataDemo007 {

    @Override
    public String getRuques() {
        return null;
    }
}


public class ThreadPoolDemo07 {

    public RealDataDemo007 realDataDemo007;

    public volatile static boolean isFlag = false;


    public synchronized String getRealDataDemo007() {

        while (!isFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //获取到数据 直接返回
        return realDataDemo007.getRuques();

    }

    public synchronized void setRealDataDemo007(RealDataDemo007 realDataDemo007) {

        // 如果直接获取到数据 直接返回
        if (isFlag) {
            return;
        }

        //如果没有获取到数据 传递真实对象
        this.realDataDemo007 = realDataDemo007;
        isFlag = true;

        //进行通知
        notify();
    }
}
