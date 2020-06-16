package course.fileAndIO1_1127.file;

import java.io.File;

//遍历构造方法中给出的目录（文件夹） 两种方法：
//public String[] list() : 返回一个String数组，表示该file目录中的所有子文件或目录。（只打印名称）
//public File[] listFiles() :返回一个file数组，表示该file目录中的所有子文件或目录。（打印完整的绝对路径）
public class Demo {
    public static void main(String[] args) {

        File file = new File("//Users//dori//task");
        String[] arr = file.list();
        for (String filename : arr) {
            System.out.println(filename);
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }

    }
}
