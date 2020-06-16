package course.fileAndIO2_1128.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestObj6 {
    public static void main(String[] args) throws Exception{
        Student student1 = new Student("a",16);


        String fileName = "a.txt";
        OutputStream os = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(student1);
        oos.close();
        os.close();




    }
}
