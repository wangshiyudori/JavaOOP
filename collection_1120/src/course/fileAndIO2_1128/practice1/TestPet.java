package course.fileAndIO2_1128.practice1;

import java.io.*;

//替换文本文件指定位置的内容，并将替换后的内容写入到一个新的文件中。
public class TestPet {
    public static void main(String[] args) throws Exception{
        //1. 读取模版文件
        String templeFile = "phone.txt";
        String outFileName = "cReplace.txt";
        File file = new File(templeFile);
        File outFile = new File(outFileName);

        String line =null;
        String tem = null;
        StringBuffer stringBuffer = new StringBuffer();

        InputStream inputStream =new FileInputStream(file);
        OutputStream outputStream =new FileOutputStream(outFileName);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        while ((line = bufferedReader.readLine()) != null){
            stringBuffer.append(line);
        }
        tem = stringBuffer.toString();

        //2。替换模版内容
        tem = tem.replace("{name}","王冰峰").replace("{type}","狗狗")
                .replace("{master}","王诗雨");

        //3。写入新的内容
        bufferedWriter.write(tem);
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        outputStreamWriter.close();
        inputStreamReader.close();
        outputStream.close();
        inputStream.close();


    }
}
