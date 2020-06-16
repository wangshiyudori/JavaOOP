package com.reflect;

import com.domain.Person;
import com.domain.Student;

public class reflectDemo1 {
    public static void main(String[] args) throws Exception {

        //1、Class.forName( “全类名” ) ：将字节码文件加载进内存，返回class对象。
        Class cls1 = Class.forName("com.domain.Person");
        System.out.println(cls1);
        //2、类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3、对象.getClass( )
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //==比较三个对象 不同的引用是否指向堆内存中同一个对象
        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);

        Class c = Student.class;
        System.out.println(c==cls1);
    }
}
