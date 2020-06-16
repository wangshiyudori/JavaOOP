package course.fileAndIO2_1128.serializable;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class TestLists7 {
    public static void main(String[] args) throws Exception{
        List<Student> lists = null;
        String fileName = "b.txt";
        InputStream is = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(is);

        lists = (List<Student>) ois.readObject();
         ois.close();
         is.close();

         for (Student s : lists)
        System.out.println(s.getName()+s.getAge());
    }
}
