package com.BuilderPattern;

/**
 * 创建人体Builder 在使用设计模式的时候一定要学会使用抽象类或者接口
 */
public interface PersonBuilder {

    void builderHead();
    void builderBody();
    void builderFoot();
    void builderAge(int age);

    //组件部件
    Person getPerson();

}
