package course.collection1_1120.generic;

import course.collection1_1120.arrayList.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo_Generic {
    public static void main(String[] args) {
        //泛型集合的第一个功能：类型约束
        List<News> news = new ArrayList<News>();
        News news1 = new News("第一条","范冰冰偷税漏税","狗仔1号");
        News news2 = new News("第二条","刘强东性侵门","狗仔2号");
        news.add(news1);
        news.add(news2);
        for (int i=0; i< news.size();i++) {
            News n = news.get(i);
            System.out.println(n.getID()+"\t"+n.getName()+"\t"+n.getCreator());
        }
        System.out.println("-------------------------");

        //泛型集合的第二个功能：无需类型转换
        Map<String,News> maps = new HashMap<String, News>();
        maps.put(news1.getID(),news1);
        maps.put(news2.getID(),news2);

        for (String s : maps.keySet()) {
            System.out.println(maps.get(s).getID()+"\t"+maps.get(s).getName()+"\t"+maps.get(s).getCreator());
        }

//        for ( : ) {
//
//        }

    }
}
