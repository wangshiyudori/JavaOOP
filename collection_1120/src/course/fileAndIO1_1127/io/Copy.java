package course.fileAndIO1_1127.io;

import java.io.*;

//实现文件复制的功能
public class Copy {
    public static void main(String[] args) {
        //1. 使用文件流读取文件
        //2. 使用文件流写入文件
        String inFailName  = "a.txt";
        String outFailName = "b.txt";
        File inFail = new File(inFailName);
        File outFail = new File(outFailName);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        byte[] content = new byte[1024];

        try {
             inputStream = new FileInputStream(inFail);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
             outputStream = new FileOutputStream(outFail);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //使用读写方法
        try {
            content = inputStream.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            outputStream.write(content);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //关闭流
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
