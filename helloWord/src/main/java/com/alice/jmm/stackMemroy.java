package com.alice.jmm;

/**
 * 栈内存溢出
 */
public class stackMemroy {

    private static int count;

    public static void count(){
        try {
            count++;
            count();
        } catch (Exception e) {
            System.err.println("最大深度==>" + count);
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        count();
    }
}
