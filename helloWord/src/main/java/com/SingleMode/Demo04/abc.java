package com.SingleMode.Demo04;

public class abc {

    public static void main(String[] args) {
        String str = "Hello";
        modify(str);
        System.out.println(str);
    }

    public static void modify(String str){
        str += "str";
    }
}
