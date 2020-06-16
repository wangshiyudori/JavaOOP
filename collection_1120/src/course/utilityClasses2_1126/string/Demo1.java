package course.utilityClasses2_1126.string;

public class Demo1 {
    public static void main(String[] args) {
        //1、使用String对象存储字符串
        String s1 = "Hello";
        String s5 = "Hello";
        String s2 = new String();
        s2 = "大象";
        String s3 = new String("臭傻子");
        String s4 = new String("臭傻子");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        //2  .length() :返回字符串中的字符数
        System.out.println(s1.length());

        //3  .equals()  :比较存储在两个字符串对象的内容是否一致
        System.out.println(s1.equals(s2));
        System.out.println("比较s3和s4的内容："+s3.equals(s4));
            //  == : 比较两个字符串的内存地址
        System.out.println("比较s3和s4的地址:" + (s3 == s4));
        System.out.println("比较s1和s5的地址："+(s1 == s5));

        //4  （应用：登录或验证时不用考虑大小写问题）
        //   .equalsIgnoreCase  :忽略大小写进行内容的比较
        //   .toLowerCase() : 转成小写
        //   .toUpperCase() : 转成大写
        String s6 = "abC";
        String s7 = "Abcabcbc";
        System.out.println(s6.equalsIgnoreCase(s7));
        System.out.println(s6.toLowerCase());
        System.out.println(s7.toUpperCase());

        //5  .concat() : 字符串的连接 （之前通过 + 进行拼接）
        System.out.println(s6.concat(s3));

        //6   .indexOf(int ch)  : 搜索第一个出现的字符ch 或 字符串 value，返回索引值，如果没有找到，则返回-1
        //    .indexOf(String value)  :
        System.out.println(s6.indexOf('C'));
        System.out.println(s3.indexOf("臭"));
        System.out.println("=======================");

        //7   .lastIndexOf  :（倒着数找相对应的索引）搜索最后一个出现的字符或字符串 返回索引值。没有，-1。
        System.out.println(s7.lastIndexOf('c'));
        System.out.println();

        //8   .substring  : 返回从索引值开始的字符串内容 或  索引范围内的字符串内容：左闭右包
        System.out.println(s3.substring(1));
        System.out.println(s3.substring(1,2));

        //10  .trim  : 修剪掉前后空格
        String s8 = new String("  臭傻子是王冰峰 ");
        System.out.println("_"+s8+"_");
        System.out.println("_"+s8.trim()+"_");

    }
}
