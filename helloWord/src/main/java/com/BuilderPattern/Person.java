package com.BuilderPattern;

/**
 * 给出一个抽象接口,以规范产品对象的各个组成成分的建造.
 * 这个接口规定要实现复杂对象的哪些部分的创建
 * 并不涉及具体的对象部件的创建
 */
public class Person {
    private String head;
    private String body;
    private String foot;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
