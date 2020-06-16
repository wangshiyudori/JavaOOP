package course.collections1_1121.Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPerson {
    public static void main(String[] args) {
        List<Person> lists = new ArrayList<>();
        Person p1 = new Person("aa",10,4000);
        Person p2 = new Person("cc",30,6000);
        Person p3 = new Person("dd",20,3000);
        Person p4 = new Person("bb",20,8000);
        lists.add(p1);
        lists.add(p2);
        lists.add(p3);
        lists.add(p4);
        //对象是person，所以排序的时候要在类里进行排序标准的设定
        Collections.sort(lists);
        for ( Person s: lists) {
            System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getSalary());
        }

        int index = Collections.binarySearch(lists,p1);
        System.out.println(index);

        Person min = Collections.min(lists);
        System.out.println(min.getAge()+"\t"+min.getSalary());
    }
}
