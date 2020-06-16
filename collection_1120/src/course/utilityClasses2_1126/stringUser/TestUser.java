package course.utilityClasses2_1126.stringUser;

import java.util.Scanner;

public class TestUser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String psd = input.next();

        User user = new User("Tom","123456");
        user.login(name,psd);
        user.register(name,psd);
//        user.setName(name);
//        try {
//            user.setPsd(psd);
//            System.out.println("注册成功！");
//        } catch (PwdLengthException e) {
//            System.out.println("注册失败！");
//            System.out.println("原因："+e.getMessage());
//        }

    }

}
