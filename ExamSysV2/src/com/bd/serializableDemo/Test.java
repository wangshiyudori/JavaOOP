package com.bd.serializableDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        BanJi banJi = new BanJi();
        banJi.setName("k52");

        User user1 =new User(1,"王冰峰","666",new Date());
        User user2 =new User(2,"王诗雨","888",new Date());

        banJi.addUser(user1);
        banJi.addUser(user2);
        JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
        String json= JSON.toJSONString(banJi, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(json);



//        User user =new User(1,"小象","456",new Date());
//        JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
//        String json= JSON.toJSONString(user, SerializerFeature.WriteDateUseDateFormat);
//        System.out.println(json);


//        User user =new User("大象","123");
//        String json= JSON.toJSONString(user);
//        System.out.println(json);






//序列化： 将对象从内存 存到 磁盘永久介质
//        User user =new User("aaa","bbb");
//        String filePath = "/Users/dori/Documents/111.txt";
//        File file = new File(filePath);
//
//        ObjectOutputStream objectOutputStream = null;
//        try {
//            OutputStream outputStream = new FileOutputStream(file);
//            objectOutputStream = new ObjectOutputStream(outputStream);
//            objectOutputStream.writeObject(user);
//            objectOutputStream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        //反序列化：从文件中读取对象到内存
//        User u = null;
//        String filePath = "/Users/dori/Documents/111.txt";
//        File file = new File(filePath);
//
//        InputStream inputStream=null;
//        try {
//            inputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            try {
//                u = (User)objectInputStream.readObject();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(u.getUserName()+"\t"+u.getUserPwd());



    }
}
