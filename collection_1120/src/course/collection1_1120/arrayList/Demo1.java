package course.collection1_1120.arrayList;

import java.util.ArrayList;

//插入 修改 用linkedList; 遍历 用arrayList;
public class Demo1 {
    public static void main(String[] args) {
        //类似于数组的操作
        ArrayList arrayList = new ArrayList();

        //1、集合的长度 size
        System.out.println(arrayList.size());
        //添加集合元素
        arrayList.add("aa");
        arrayList.add(0,"bb");
        //遍历元素
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i).toString());
        }
        //设置元素
        arrayList.set(0,"abcd");
        System.out.println(arrayList.get(0).toString());
        //删除元素
        arrayList.remove(0);

        //清空集合
        arrayList.clear();
//        arrayList.removeAll();
        System.out.println(arrayList);
    }
}
