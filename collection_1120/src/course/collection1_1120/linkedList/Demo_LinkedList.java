package course.collection1_1120.linkedList;

import java.util.LinkedList;

public class Demo_LinkedList {
    public static void main(String[] args) {

        //在链表中，add remove get 都有首尾操作

        LinkedList linkedList = new LinkedList();
        News n1 = new News("热门一","奶茶妹妹婚变","娱记1号");
        News n2 = new News("热门二","杨丞琳李荣浩秘密领证","娱记2");

        linkedList.addFirst(n2);
        linkedList.addLast(n1);

        for (int i = 0; i < linkedList.size(); i++) {
            News news = (News)linkedList.get(i);
            System.out.println(news.getID()+"\t\t"+news.getName()+"\t\t"+news.getCreator());
        }

        //输出索引值元素
          News m = (News)linkedList.get(0);
        System.out.println(m.getID()+m.getName()+m.getCreator());
        //修改里面的内容
        linkedList.set(0,new News("3","大象","娱记"));
         News l = (News)linkedList.get(0);
        System.out.println(l.getID()+l.getName()+l.getCreator());
    }


}
