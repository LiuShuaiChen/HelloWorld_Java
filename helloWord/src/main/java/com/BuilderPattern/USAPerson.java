package com.BuilderPattern;

/**
 * 构建美国人
 */
public class USAPerson implements PersonBuilder {

    private Person person;

    public USAPerson() {
        person = new Person();
    }

    @Override
    public void builderHead() {
        System.out.println("com.BuilderPattern.USAPerson.builderHead");
        person.setHead("com.BuilderPattern.USAPerson.builderHead");
    }

    @Override
    public void builderBody() {
        System.out.println("com.BuilderPattern.USAPerson.builderBody");
        person.setBody("com.BuilderPattern.USAPerson.builderBody");
    }

    @Override
    public void builderFoot() {
        System.out.println("com.BuilderPattern.USAPerson.builderFoot");
        person.setFoot("com.BuilderPattern.USAPerson.builderFoot");
    }

    @Override
    public void builderAge(int age) {
        System.out.println("com.BuilderPattern.USAPerson.builderAge");
        person.setAge(age);
    }

    @Override
    public Person getPerson() {
        return person;
    }
}
