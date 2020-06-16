package course.Random_1123.sixFigures;

import java.util.Random;

public class Way4 {
    public static void main(String[] args) {
        //依旧使用 random.nextInt() 方法

        for (int i = 0; i < 5; i++) {
            int flag = new Random().nextInt(999999);
            if (flag<100000){
                flag+=100000;
            }
            System.out.println(flag);
        }
    }
}
