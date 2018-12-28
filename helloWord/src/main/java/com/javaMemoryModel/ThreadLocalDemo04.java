package com.javaMemoryModel;

/**
 * 生产者消费者
 * 2018-12-28 11:05:15
 * 多线程通讯
 */
public class ThreadLocalDemo04 {

    public static void main(String[] args) {
        Res04 res04 = new Res04();
        InitThread initThreadDemo = new InitThread(res04);
        OutThread outThreadDemo = new OutThread(res04);
        initThreadDemo.start();
        outThreadDemo.start();

    }
}

// 生产者线程
class InitThread extends Thread {

    public Res04 res04;

    public InitThread(Res04 res04) {
        this.res04 = res04;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res04) {

                if (res04.isFlag()){
                    try {
                        // 线程进入等待
                        res04.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count == 0) {
                    res04.setName("小红");
                    res04.setSex("女");
                } else {
                    res04.setName("科南");
                    res04.setSex("男");
                }
            }
            count = (count + 1) % 2;
            res04.setFlag(true);
        }
    }
}

//消费者线程
class OutThread extends Thread {

    public Res04 res04;

    public OutThread(Res04 res04) {
        this.res04 = res04;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (res04) {

                    if (res04.isFlag()){
                        res04.wait();
                    }

                    Thread.sleep(50);
                    if (res04.getSex() != null && res04.getName() != null){
                        System.out.println("res.name==>" + res04.getName() + ", res.sex==>" + res04.getSex());
                    }
                    // 标记当前线程为等待
                    res04.setFlag(false);
                    // 唤醒被等待的线程
                    res04.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//共享对象
class Res04 {
    //名字
    private String name;
    //性别
    private String sex;

    private boolean flag;

    public boolean isFlag() {
        return flag = false;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}