package course.collection1_1120.practice1;

import java.util.HashMap;
import java.util.Map;

public class TestStudent {
    public static void main(String[] args) {

        Map<String,Student> students = new HashMap<>();
        Student student1 = new Student("王冰峰","男");
        Student student2 = new Student("王诗雨","女");
        students.put("Jack",student1);
        students.put("Dori",student2);

        for (String s : students.keySet()) {
            System.out.println( s+"中文名是："+students.get(s).getName()+"\t性别是："+students.get(s).getSex());
        }

    }


}
