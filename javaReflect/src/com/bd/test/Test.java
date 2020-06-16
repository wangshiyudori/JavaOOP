package com.bd.test;

import com.bd.entity.Person;
import com.bd.entity.Student;
import com.bd.entity.Teacher;
import com.bd.utils.FileUtil;

import java.io.File;
import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();


        Class<?> className = null;
        try {
            className=Class.forName("com.bd.entity.Teacher");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Constructor<?> constructor = className.getDeclaredConstructor(Integer.class,String.class);
//             Object obj= constructor.newInstance(1,"zs");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Person o = new Teacher();
        if (o instanceof Teacher ){
            ((Teacher)o).teach();
        }
        else if (o instanceof Student){
            ((Student) o).play();
        }else {
            System.out.println("无类型");
        }
    }
}
