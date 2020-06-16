package course.utilityClasses1_1125.packaging;

public class Demo {
    public static void main(String[] args) {
        //装箱：基本类型转换为包装类的对象

        Integer integer1 = new Integer(3);
        int a = 5;
        Integer integer2 = a;
        //除character类外，其他包装类可将一个字符串作为参数构造他们的实例。
        Integer integer3 = new Integer("7");
        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(integer3);

        Character character1 = new Character('a');
        char b = 'a';
        Character character2 = new Character(b);
        System.out.println(character1);
        System.out.println(character2);

        Boolean b1 = new Boolean(true);
        Boolean b3 = new Boolean("TRue");
        Boolean b2 = new Boolean("大象");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);


    }
}
