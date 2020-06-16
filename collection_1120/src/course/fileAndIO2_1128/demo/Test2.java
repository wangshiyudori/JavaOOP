package course.fileAndIO2_1128.demo;

import java.io.*;

//在文本文中写入内容
public class Test2 {
    public static void main(String[] args) {
        String filePath = "b.txt";
        File file = new File(filePath);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(outputStream,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        try {
            bufferedWriter.newLine();
            bufferedWriter.write("我爱北京天安门");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
