package com.bd.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public List<String> readFile(String filePath){
//        String[] lines = new String[10];
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader= new BufferedReader(fileReader);
        try {
            String line = bufferedReader.readLine();

            while (line!=null){
                lines.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
