package course.fileAndIO1_1127.io;

import java.io.File;
import java.io.FileInputStream;

//遍历输出文件内容
public class Demo {
    public static void main(String[] args) throws Exception {
        String fileName = "a.txt";
        File file = new File(fileName);

        //1 定义输入流 字节流 8
        FileInputStream fileInputStream = new FileInputStream(file);
        //2 判断是否还有可以读取的内容
        while (fileInputStream.available() > 0) {
            //读取字节
            int m = fileInputStream.read();
            System.out.print((char) m);
        }


    }
}
