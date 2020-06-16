package com.singleton;

public class Test {
    public static void main(String[] args) {
//        SingleTon t1 = new SingleTon();
//        SingleTon t2 = new SingleTon();
//        System.out.println(t1);
//        System.out.println(t2);

        SingleTon t1 = SingleTon.getInstance();
        SingleTon t2 = SingleTon.getInstance();
        System.out.println(t1);
        System.out.println(t2);
    }

}
