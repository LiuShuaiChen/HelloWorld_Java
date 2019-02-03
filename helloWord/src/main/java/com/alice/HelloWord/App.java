package com.alice.HelloWord;

public class App {

    private String str;

    public String getStr() {
        return str == null ? "HelloWorld" : str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public static void getHelloWorld(){
        System.out.println("HelloWorld");
    }

    public static void main(String[] args){
        System.out.println("Hello World!");
        getHelloWorld();
        App app = new App();
        System.out.println(app.getStr());
    }
}
