package course.fileAndIO1_1127.io;

/*
i : input 输入（读取） 把硬盘中的数据读取到内存（临时存储）中使用
o : output 输出 （写入） 把内存中的数据写入到硬盘（永久存储）中保存
流 : 数据（字符，字节） 1个字符 = 2个字节  1个字节 = 8个二进制位 (！无论什么样的流对象，底层传输的永远是二进制数据)
                                      1个字节 = 8个比特位 （硬盘中存储的都是字节）
分类：
字节流  字节输入流(inputStream)     字节输出流(outputStream)
字符流  字符输入流(Reader)          字符输出流(Writer)

fileOutputStream : 文件字节输出流
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//字节输出流写入数据到文件
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //1. 创建对象
        FileOutputStream fos = new FileOutputStream("phone.txt");
        File file = new File("phone.txt");
        System.out.println(file.getAbsolutePath());
        //2. 调用写入方法：只写一个字节
        fos.write(97);
        //3. 关闭资源
        fos.close();
    }
}
