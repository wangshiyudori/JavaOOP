package course.fileAndIO2_1128.serializable1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args) throws Exception{
        Pet pet1 = new Pet("aa",100,20);
        Pet pet2 = new Pet("bb",200,30);
        Pet pet3 = new Pet("cc",300,40);
        Pet pet4 = new Cat("dd",333,666,"美短银渐层");
        List<Pet> lists = new ArrayList<>();
        lists.add(pet1);
        lists.add(pet2);
        lists.add(pet3);
        lists.add(pet4);

        String fileName = "person.xml";
        OutputStream os = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(lists);

        oos.flush();
        oos.close();
        os.close();


    }
}
