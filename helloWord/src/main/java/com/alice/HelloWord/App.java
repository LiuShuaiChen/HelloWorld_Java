package com.alice.HelloWord;

/**
 * Hello world!
 *
 */
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

    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
