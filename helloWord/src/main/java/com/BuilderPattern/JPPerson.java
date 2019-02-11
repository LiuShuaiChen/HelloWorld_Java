package com.BuilderPattern;

/**
 * 构建日本人
 */
public class JPPerson implements PersonBuilder {
    private Person person;

    public JPPerson() {
        person = new Person();
    }

    @Override
    public void builderHead() {
        System.out.println("com.BuilderPattern.JPPerson.builderHead");
        person.setHead("com.BuilderPattern.JPPerson.builderHead");
    }

    @Override
    public void builderBody() {
        System.out.println("com.BuilderPattern.JPPerson.builderBody");
        person.setBody("com.BuilderPattern.JPPerson.builderBody");
    }

    @Override
    public void builderFoot() {
        System.out.println("com.BuilderPattern.JPPerson.builderFoot");
        person.setFoot("com.BuilderPattern.JPPerson.builderFoot");
    }

    @Override
    public void builderAge(int age) {
        System.out.println("com.BuilderPattern.JPPerson.builderAge");
        person.setAge(age);
    }

    @Override
    public Person getPerson() {
        return person;
    }
}
