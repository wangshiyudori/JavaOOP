package course.utilityClasses2_1126.emailAddress;

import java.util.Scanner;

public class TestEmail {
    public static void main(String[] args) {
        //判断邮箱格式是否正确。
        Email email = new Email();
        System.out.println("请输入邮箱地址：");
        Scanner input = new Scanner(System.in);
        String address = input.next();

        try {
            email.setEmailAddress(address);
        } catch (EmailFormatException e) {
            System.out.println(e.getMessage());
        }

        //判断文件名是否正确.
        System.out.println("请输入文件名：");
        String fileName =input.next();
        int index = fileName.toLowerCase().lastIndexOf(".java");
        if (index!= fileName.length()-5){
            System.out.println("文件名不正确。");
        }else {
            System.out.println("文件名正确。");
        }

    }
}
