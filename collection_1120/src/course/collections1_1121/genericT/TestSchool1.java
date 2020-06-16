package course.collections1_1121.genericT;

import java.util.ArrayList;
import java.util.List;

public class TestSchool1 {
    public static void main(String[] args) {
        School1<Teacher> school1 = new School1<>();

        List<Teacher> lists = new ArrayList<>();
        Teacher t = new Teacher("王",18,3);
        Teacher t1 = new Teacher("李",20,0);
        Teacher t2 = new Teacher("刘",40,6);
        lists.add(t);
        lists.add(t1);
        lists.add(t2);

        school1.setLists(lists);

        for ( Teacher tt: school1.getLists()) {
            System.out.print(tt.getName());
            tt.say();
        }

    }
}
