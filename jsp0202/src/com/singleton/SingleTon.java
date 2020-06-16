package com.singleton;

public class SingleTon {
    //单例模式
//    private static SingleTon singleTon;   //定义静态。否则没办法用实例的成员变量和方法。
//    public static SingleTon getInstance(){
//        if (singleTon==null){
//            singleTon = new SingleTon();
//        }
//        return singleTon;
//    }
//
//    //（不行让外界new SingleTon，就要私有化它。） private 没法实例化
//    private SingleTon(){
//
//    }


    //懒汉模式
//    private volatile static SingleTon singleTon;   //定义静态。否则没办法用实例的成员变量和方法。
//    public synchronized static SingleTon getInstance(){
//        if (singleTon==null){
//            singleTon = new SingleTon();
//        }
//        return singleTon;
//    }
//
//    private SingleTon(){
//
//    }



    //饿汉模式
    private static final SingleTon singleTon = new SingleTon();
    public static SingleTon getInstance(){
        return singleTon;
    }

    private SingleTon(){

    }

}
