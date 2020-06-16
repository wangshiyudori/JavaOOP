package course.collection1_1120.map;

import java.util.HashMap;
import java.util.Map;

public class Demo_Map {
    public static void main(String[] args) {

        Map map = new HashMap();
        //map添加元素：.put
        map.put("CN","China");
        map.put("JP","Japan");
        map.put("AM","America");
        //map输出键值对：.entrySet
        System.out.println(map.entrySet());
        //输出值：.values
        System.out.println(map.values());
        //输出键：.keySet
        System.out.println(map.keySet());
        //遍历的三种方式
        System.out.println("-----------------");
        for (Object o :map.keySet()) {
            System.out.println(map.get(o.toString()));
        }
        System.out.println("-----------------");
        for (Object p : map.values()){
            System.out.println(p.toString());
        }
        System.out.println("-----------------");
        for ( Object q : map.entrySet()) {
            System.out.println(q);

//            Map.Entry r = (Map.Entry) q;
//            String s = r.getKey().toString()+"="+r.getValue().toString();
//            System.out.println(s);
        }
    }
}
