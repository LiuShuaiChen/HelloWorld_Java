package com.SingleMode.Demo04;

public class abc {

    public static void main(String[] args) {
        String str = "Hello";
        modify(str);
        System.out.println(str);
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");

    }

    public static void modify(String str) {
        str += "str";
    }
}
