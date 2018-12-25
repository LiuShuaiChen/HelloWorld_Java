package com.javaMemoryModel;

/**
 * ThreadLocal 线程共享
 *
 * @author alice
 * 2018-12-23 19:36:38
 */
public class ThreadLocalDemo01 extends Thread {

    private Res res;

    public ThreadLocalDemo01() {
    }

    public ThreadLocalDemo01(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程 " + Thread.currentThread().getName() + "==>" + res.getCount());
        }
    }

    public static void main(String[] args) {
        Res res1 = new Res();
        Res res2 = new Res();
        Res res3 = new Res();

        Res res = new Res();

//        ThreadLocalDemo01 demo01 = new ThreadLocalDemo01(res1);
//        ThreadLocalDemo01 demo02 = new ThreadLocalDemo01(res2);
//        ThreadLocalDemo01 demo03 = new ThreadLocalDemo01(res3);

        ThreadLocalDemo01 demo01 = new ThreadLocalDemo01(res);
        ThreadLocalDemo01 demo02 = new ThreadLocalDemo01(res);
        ThreadLocalDemo01 demo03 = new ThreadLocalDemo01(res);

        demo01.setName("demo01");
        demo02.setName("demo02");
        demo03.setName("demo03");

        demo01.start();
        demo02.start();
        demo03.start();
    }
}

class Res {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        };
    };

//    private Integer count = 0;

    public Integer getCount() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}