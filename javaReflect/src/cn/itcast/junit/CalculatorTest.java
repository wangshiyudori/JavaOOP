package cn.itcast.junit;

public class CalculatorTest {
    public static void main(String[] args) {
        //创建对象
        Calculator c = new Calculator();
        //调用方法
        int add = c.add(2, 9);
        int sub = c.sub(1, 1);
        System.out.println(add);
        System.out.println(sub);
    }

}
