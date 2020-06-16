package com.bd.entity;

public class Teacher extends Person{
    private Integer id;
    private String name;

    public Teacher() {
    }

    public Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void teach(){
        System.out.println("teacher lesson");
    }
}
