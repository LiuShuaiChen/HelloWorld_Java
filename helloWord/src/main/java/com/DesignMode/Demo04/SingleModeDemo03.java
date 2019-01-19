package com.DesignMode.Demo04;


/**
 * 静态内部类
 */
public class SingleModeDemo03 {

    public SingleModeDemo03() {
        System.out.println("静态内部类加载");
    }

    //静态内部类
    public static class singleClassLoad{
        private static final SingleModeDemo03 singleModeDemo03 = new SingleModeDemo03();
    }

    public static SingleModeDemo03 getInstance(){
        System.out.println("com.DesignMode.Demo04.SingleModeDemo03.getInstance");
        return singleClassLoad.singleModeDemo03;
    }


}
