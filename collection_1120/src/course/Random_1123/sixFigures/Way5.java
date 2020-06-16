package course.Random_1123.sixFigures;

import java.util.Random;

public class Way5 {
    public static void main(String[] args) {
        //引入了一个source 源字符串，从这个字符串里可以随机生成一个子串返回，很多pc网站用这个方法生成带字母数字的验证码，
        // 原理类似way3

        for (int i = 0; i <5 ; i++) {
            //这里在sources里面加一些字母，就可以生成PC站的验证码了。
            String sources = "0123456789";
            Random random = new Random();
            StringBuffer flag = new StringBuffer();
            //通过StringBuffer的添加功能，一次添加一个，6次，拼成一个六位数
            for (int j = 0; j < 6; j++) {
                //chatAt.(int index) : 返回指定索引位置的字符。
                flag.append(sources.charAt(random.nextInt(10)));
            }
            System.out.println(flag.toString());
        }
    }
}
