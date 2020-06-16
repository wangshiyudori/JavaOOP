package course.fileAndIO1_1127.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

//字节输入流一次读取多个字节的方法
public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        byte[] bytes = new byte[2];
        int len = fis.read(bytes);
        System.out.println(len);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));

        fis.close();
    }
}
