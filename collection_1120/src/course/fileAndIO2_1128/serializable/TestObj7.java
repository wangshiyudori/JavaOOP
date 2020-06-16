package course.fileAndIO2_1128.serializable;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class TestObj7 {
    public static void main(String[] args) throws Exception{
        Student student1 = null;
        String fileName = "a.txt";
        InputStream is = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(is);
         student1 = (Student) ois.readObject();
         ois.close();
         is.close();


        System.out.println(student1.getName()+student1.getAge());
    }
}
