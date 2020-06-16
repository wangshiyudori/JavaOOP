package course.collection1_1120.set;

import course.collection1_1120.linkedList.News;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo_Set {
    public static void main(String[] args) {
        Set set = new HashSet();
        News news1 = new News("第一条","范冰冰偷税漏税","狗仔1号");
        News news2 = new News("第二条","刘强东性侵门","狗仔2号");

        set.add(news1);
        set.add(news2);
//        set.remove(news2);

        //遍历的两种方式：增强型for循环 迭代器
        for (Object o :set) {
           News b = (News)o;
            System.out.println(b.getID()+"\t"+b.getName()+"\t"+b.getCreator());
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            News a = (News) iterator.next();
            System.out.println(a.getID()+"\t"+a.getName()+"\t"+a.getCreator());
        }

        //判断是否包含有某个对象
        System.out.println(set.contains(news2));
        set.clear();
    }
}
