package course.fileAndIO2_1128.serializable1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Test7 {
    public static void main(String[] args) throws Exception{
        List<Pet> lists = null;
        String fileName = "person.xml";
        InputStream is = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(is);
         lists = (List<Pet>)ois.readObject();

         ois.close();
         is.close();

         for (Pet p: lists){
             if (p instanceof Cat){
                 System.out.println(p.getName()+p.getHealth()+p.getLove()+((Cat) p).getBrand());
             }else {
                 System.out.println(p.getName()+p.getHealth()+p.getLove());
             }
         }


    }
}
