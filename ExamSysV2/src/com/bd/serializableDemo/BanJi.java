package com.bd.serializableDemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BanJi implements Serializable {
    private String name;
    private List<User> user;

    public BanJi() {
        user = new ArrayList<User>();
    }

    public BanJi(String name, List<User> user) {
        this.name = name;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public void addUser(User user){
        this.user.add(user);
    }
}
