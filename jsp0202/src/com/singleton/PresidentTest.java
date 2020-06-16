package com.singleton;

public class PresidentTest {
    public static void main(String[] args) {
        President president1 = President.getInstance();
        president1.setName("特朗普");
        System.out.println(president1);

        President president2 = President.getInstance();
        president2.setName("aaa");
        System.out.println(president2);

        System.out.println(president1.getName());
        //说明president1 和 president2 是同一个操作对象
    }
}
