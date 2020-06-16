package course.Random_1123.sixFigures;

public class Way2 {
    public static void main(String[] args) {
        // 面试可以用到的一种方式，一行代码实现，思路是：math.random()范围是[0.0, 1.0)，
        // 那么math.random()*9+1一定是小于10的，(Math.random()*9+1)*10 0000一定是<10*10 0000=100 0000的一个数

        for (int i = 0; i < 5; i++) {
            System.out.println((int)((Math.random()*9+1)*100000));
        }
    }
}
