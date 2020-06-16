package course.fileAndIO1_1127.io;

import java.io.*;

//实现在已有文件中输出内容
public class Output {
    public static void main(String[] args) {
        File file = new File("a.txt");
        System.out.println(file.getAbsolutePath());
        //绝对路径：/Users/dori/IdeaProjects/collection_1120/a.txt
        String s = "abcd";

        try {
            //1 定义输出流对象： 文件输出流
            OutputStream outputStream = new FileOutputStream(file);
            try {
                //2 把字符串转换成byte[]
                byte[] content = s.getBytes();
                //3 写入内容到文件里面
                outputStream.write(content);
                //4 设置刷新flush
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //5 关闭资源
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
