package course.fileAndIO2_1128.demo;

import java.io.*;

public class Test3 {
    public static void main(String[] args) {
        String fileName = "cat.jpg";
        String fileName2 = "cat2.jpg";
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
            outputStream = new FileOutputStream(fileName2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


        int data = 0;
        try {
            while (dataInputStream.available()>0){
                data = dataInputStream.read();
                dataOutputStream.write(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            dataInputStream.close();
            inputStream.close();
            dataOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
