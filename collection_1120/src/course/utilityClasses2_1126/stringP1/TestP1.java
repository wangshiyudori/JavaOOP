package course.utilityClasses2_1126.stringP1;

import java.util.Scanner;

public class TestP1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String password1 = input.next();
        System.out.println("请再次输入密码：");
        String password2 = input.next();

        Member member = new Member();
        member.register(name,password2);
        member.isEqual(password1,password2);

//        boolean isRegister= member.isEqual(password1,password2);
//        if (isRegister){
//            member.register(name,password2);
//        }else{
//            System.out.println("Failed");
//        }

    }
}
