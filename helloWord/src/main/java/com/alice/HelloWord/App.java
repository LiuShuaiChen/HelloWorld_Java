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

        app = null;
        System.gc();

        //Exception in thread "main" java.lang.StackOverflowError
        StudentA studentA = new StudentA();
    }

    //当前类被GC回收就会执行
    @Override
    protected void finalize() throws Throwable {
        System.out.println("回收内存就执行");

    }
}
