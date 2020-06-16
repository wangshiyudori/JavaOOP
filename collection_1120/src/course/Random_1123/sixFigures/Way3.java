package course.Random_1123.sixFigures;

import java.util.Random;

public class Way3 {
    public static void main(String[] args) {
        //random.nextInt(10) : 生成一个[0,10)范围内  (大于等于0小于10) 的正整数，小于10的一个正整数，
        // 既然是生成6位随机数，每个数一定是0-9之内的，就循环6次，每次从0-9随机选取一个数字拼接字符串返回即可。

        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            //random.nextInt() : 生成一个指定范围的随机数
            result += random.nextInt(10);
        }
        System.out.println(result);
    }
}
