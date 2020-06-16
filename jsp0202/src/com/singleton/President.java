package com.singleton;
//用懒汉模式做的总统 因为总统只能有一个

public class President {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private President(){

    }

    private volatile static President president;

    public synchronized static President getInstance(){
        if (president == null){
            president= new President();
        }
        return president;
    }
}
