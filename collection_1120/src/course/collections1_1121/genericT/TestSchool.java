package course.collections1_1121.genericT;

public class TestSchool {
    public static void main(String[] args) {
        School<Teacher> school = new School<>();
        Teacher t =new Teacher();
        school.setT(t);
        school.getT().say();

        School<Student> school1 = new School<>();
        Student s = new Student();
        school1.setT(s);
        school1.getT().print();


    }
}
