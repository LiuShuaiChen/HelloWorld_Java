package com.DesignMode.Demo02;

public class UserEntity {

    private String name;
    private int id;

    public UserEntity() {
        System.out.println("对象进行初始化");

        // 如果在无参构造出现一个异常 so 这个对象则会创建失败
//        throw new RuntimeException();
    }

    public UserEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
