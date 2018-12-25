package com.javaMemoryModel;

public class ThreadLocalDemo02 {

    public static void main(String[] args) {
        try {
            ThreadDemo02 threadDemo02 = new ThreadDemo02();
            threadDemo02.start();
            Thread.sleep(3000);
            threadDemo02.setRunning(false);
            System.out.println("flag已经改成false");
            Thread.sleep(3000);
            System.out.println(threadDemo02.flag);
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}


class ThreadDemo02 extends Thread {

    public boolean flag = true;

    public void setRunning(boolean flag) {
        this.flag = flag;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        System.out.println("线程开始..............");
        while (flag) {

        }
        System.out.println("线程结束..............");
    }

}