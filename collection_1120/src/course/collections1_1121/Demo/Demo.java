package course.collections1_1121.Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("ccc");
        lists.add("aaa");
        lists.add("bbb");
        //排序
        Collections.sort(lists);
        for ( String s: lists) {
            System.out.println(s);
        }
        //查找最大值
        String max = Collections.max(lists);
        System.out.println(max);
        //查找索引
        int index = Collections.binarySearch(lists,"aaa");
        System.out.println(index);

    }
}
