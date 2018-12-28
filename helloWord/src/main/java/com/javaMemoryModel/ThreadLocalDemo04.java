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
                if (count == 0) {
                    res04.setName("小红");
                    res04.setSex("女");
                } else {
                    res04.setName("科南");
                    res04.setSex("男");
                }
            }
            count = (count + 1) % 2;
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
                    Thread.sleep(50);
                    System.out.println("res.name==>" + res04.getName() + ", res.sex==>" + res04.getSex());
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