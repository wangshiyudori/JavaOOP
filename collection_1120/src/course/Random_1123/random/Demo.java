package course.Random_1123.random;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(10);
            System.out.println("第"+(i+1)+"个随机数是"+num);
        }
    }
}
