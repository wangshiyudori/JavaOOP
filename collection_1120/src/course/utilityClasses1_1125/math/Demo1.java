package course.utilityClasses1_1125.math;

public class Demo1 {
    public static void main(String[] args) {
        //java.lang.Math类：提供了常用的数学运算方法 和 两个静态常量E（自然对数的底数）和PI（圆周率）。
        //Math.abs : 取绝对值
        int a  = Math.abs(-23);
        double b = Math.abs(89.99);
        System.out.println(a);
        System.out.println(b);

        //Math.max : 取最最大值
        System.out.println(Math.max(20,30));

        //Math.random : 生成的是[0.0,1.0) 之间的伪随机数。 或表达为：生成的是0.0 - 0.9之间的伪随机数。
            int random = (int) (Math.random()*10);
            System.out.println("0-9之间的随机数："+random);
    }
}
