package course.fileAndIO1_1127.file;

import java.io.File;

public class FileP1 {
    public static void main(String[] args) {
        File file = new File("a.txt");
        System.out.println(file);
        System.out.println("判断文件是否存在："+file.exists());
        System.out.println("输出文件相对路径："+file.getPath());
        System.out.println("输出文件绝对路径："+file.getAbsolutePath());
        System.out.println(file.length());
        int bu = file.length()%1024>0? 1:0;
        long k = file.length()/1024+bu;
        System.out.println(k);
        System.out.println(file.getTotalSpace()/1024/1024/1024);

        System.out.println("=====================");
        String fileName = "D:/动物管理系统.xlsx";
        File file1 = new File(fileName);
        System.out.println(file1);
        System.out.println(file.getName());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        //判断一个文件类对象是否为绝对路径
        System.out.println(file.isAbsolute());
        File f = new File("dori","IdeaProjects");
        System.out.println(f.getParent());
        System.out.println(f.getParentFile());
        //System.out.println(file.createNewFile());  ?怎么用


    }
}
