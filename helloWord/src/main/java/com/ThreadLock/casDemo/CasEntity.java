package com.ThreadLock.casDemo;

public class CasEntity {

    private int id;
    private int version;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CasEntity() {
    }

    public CasEntity(int id, int version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CasEntity{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                '}';
    }
}
