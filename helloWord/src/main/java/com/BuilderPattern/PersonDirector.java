package com.BuilderPattern;

/**
 * 调用具体建造者来创建复杂对象的各个部分,在指导者中不涉及具体产品的信息,只负责保证对象各部分完整创建或者按某种顺序创建
 *
 * 构建任务 整合所有部件
 */
public class PersonDirector {

    //创建对象是 默认初始化对象的属性
    public Person createPerson(PersonBuilder personBuilder){
        personBuilder.builderHead();
        personBuilder.builderBody();
        personBuilder.builderFoot();
        personBuilder.builderAge(1);
        return personBuilder.getPerson();
    }

    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector();
        Person usaPerson = personDirector.createPerson(new USAPerson());
        usaPerson.getHead();
        usaPerson.getBody();
        usaPerson.getFoot();
        System.out.println(usaPerson.getFoot());
        System.out.println(usaPerson.getAge());
        usaPerson.setAge(10);
        System.out.println(usaPerson.getAge());
    }
}
