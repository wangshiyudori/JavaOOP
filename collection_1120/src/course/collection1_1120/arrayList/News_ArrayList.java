package course.collection1_1120.arrayList;

import java.util.ArrayList;

public class News_ArrayList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        News news1 = new News("第一条","范冰冰偷税漏税","狗仔1号");
        News news2 = new News("第二条","刘强东性侵门","狗仔2号");

        arrayList.add(news1);
        arrayList.add(news2);

        for (int i = 0; i < arrayList.size(); i++) {
            //默认的是
            News ty = (News)arrayList.get(i);
            System.out.println(ty.getID() +"\t\t"  +ty.getName()  +"\t\t"  +ty.getCreator());
        }



    }
}
