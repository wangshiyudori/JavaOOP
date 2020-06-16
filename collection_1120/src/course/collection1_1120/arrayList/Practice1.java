package course.collection1_1120.arrayList;

//题目：生成6个1-33之间的随机整数，添加到集合，并遍历集合。
import java.util.ArrayList;
import java.util.Random;

public class Practice1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //产生随机数
        Random r = new Random();
        //循环6次，产生6个随机数
        for (int i = 0; i < 6; i++) {
            //产生1-33之间的随机数 bound：33 是0-32之间，+1后是1-33之间
            int num = r.nextInt(33)+1;
            list.add(num);
        }
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
