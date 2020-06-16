package course.utilityClasses1_1125.enumerate;

import java.util.ArrayList;
import java.util.List;

public class TestCourse {
    public static void main(String[] args) {
        List<Course> lists = new ArrayList<>();

        Course course1 = new Course("大数据开发工程师",Stage.L1);
        Course course2 = new Course("大数据挖掘工程师",Stage.L2);
        Course course3 = new Course("大数据架构师",Stage.L3);
        lists.add(course1);
        lists.add(course2);
        lists.add(course3);
        for ( Course course : lists) {
            System.out.println(course.getStage()+":"+course.getName());
        }

    }
}
