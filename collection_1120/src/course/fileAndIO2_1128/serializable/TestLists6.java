package course.fileAndIO2_1128.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestLists6 {
    public static void main(String[] args) throws Exception{
        Student student1 = new Student("a",16);
        Student student2= new Student("b",18);
        Student student3 = new Student("c",19);

        List<Student> lists = new ArrayList<>();
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);

        String fileName = "b.txt";
        OutputStream os = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(lists);
        oos.close();
        os.close();




    }
}
