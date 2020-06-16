package Properties集合;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class Demo01Properties {
    public static void main(String[] args) throws IOException {
//        show01();
//        show02();
        show03();
    }
    //使用Properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用
    /*
    注意：1、存储键值对的文件中，键与值默认的连接符号=，也可使用其他符号
         2、存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取
         3、存储键值对的文件中，键与值默认都是字符串，不用再加引号
     */
    private static void show03() throws IOException {
        //1、创建Properties集合对象
        Properties prop = new Properties();
        //2、使用Properties集合中的方法load，读取保存键值对的文件
        prop.load(new FileReader("prop.txt"));
//        prop.load(new FileInputStream("prop.txt"));
        //3、遍历Properties集合
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key+"="+value);
        }

    }












    //使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
    private static void show02() throws IOException {
        //1、创建Properties集合对象，添加数据
        Properties prop = new Properties();
        prop.setProperty("王冰峰","187");
        prop.setProperty("王诗雨","163");
        prop.setProperty("王子","180");

        //2、创建字符输出流/字节输出流，构造方法中绑定要输出的目的地
        //FileWriter fw=new FileWriter("prop.txt");


        //3、使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
        //prop.store(fw,"save data");

        //4、释放资源
        //fw.close();

        //创建的字节输出流，匿名对象，所以使用完不用关。注释掉步骤234
        prop.store(new FileOutputStream("prop2.txt"),"");
    }












    //使用Properties集合存储数据，并遍历取出Properties集合中的数据
    private static void show01() {
        //1、创建Properties集合对象
        Properties prop = new Properties();
        //2、使用setProperty往集合中添加数据
        prop.setProperty("王冰峰","187");
        prop.setProperty("王诗雨","163");
        prop.setProperty("王子","180");
        //3、使用stringPropertyNames把Properties集合中的键取出，存储到一个set集合中
        Set<String> set = prop.stringPropertyNames();
        //4、遍历set集合，取出Properties集合中的每一个键
        for (String key:set){
            String value =prop.getProperty(key);
            System.out.println(key+"---"+value);
        }
    }



}
