package course.utilityClasses1_1125.packaging;


public class Transform1 {
    public static void main(String[] args) {
        //拆箱：包装类对象转换为基本对象的值
        //包装类并不是用来取代基本数据类型的，在基本数据类型需要用对象表示时使用。

        //XXXValue: 包装类 ---> 基本数据类型
//        Integer integer = new Integer(23);
//        int a = integer.intValue();
//        System.out.println(a);
        Integer integer = 10;
        int intValue = integer;
        System.out.println(integer);

        //toString : 基本类型 ---> 字符串
        String sex = Character.toString('男');
        String sex1 = '男' + "笨蛋";
        System.out.println(sex);
        System.out.println(sex1);

        String id = Integer.toString(123);
        String id1 = 123 + "号";
        System.out.println(id);
        System.out.println(id1);

        //parseXXX : 字符串 ---> 基本数据类型
        int num = Integer.parseInt("23");
        System.out.println(num);
        boolean bool = Boolean.parseBoolean("trUe");
        //boolean类构造方法参数为String时，返回对象只能为true（不区分大小写）或false。
        boolean bool1 = Boolean.parseBoolean("wbf是臭傻子");
        System.out.println(bool);
        System.out.println(bool1);

        //valueOf : 基本类型 ---> 包装类 或 字符串 ---> 包装类
        Integer integer1 = Integer.valueOf(99);
        Integer integer2 = Integer.valueOf("99");
        Double double1 = Double.parseDouble("99.9");

        String s = String.valueOf(integer1);  //将int类型转换为了String类型
        String s1 = s + "分";
        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(double1);
        System.out.println(s1);




    }


}
