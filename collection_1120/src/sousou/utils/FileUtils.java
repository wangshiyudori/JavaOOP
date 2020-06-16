package sousou.utils;

import java.io.*;

public class FileUtils {
    public static void writeFile(String fileName, String content) throws Exception {
        File file = new File(fileName);
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.flush();
        writer.close();
        outputStream.close();

    }
}
