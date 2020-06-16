package course.superMarketMember_1122;

import java.text.SimpleDateFormat;
import java.util.*;

public class SMSystem {

    List<Member> list = new ArrayList<>();
    Scanner input = new Scanner(java.lang.System.in);

    public void print(){
        System.out.println("************欢迎进入超市会员管理系统****************");
        System.out.println("1.积分累加  2.积分兑换  3.查询剩余积分  4.修改密码    5.开卡    6.退出  ");
        System.out.println("请选择您要进行的操作：");
        choose();
    }

    public void choose(){
    int no = input.nextInt();
        switch (no){
            case 1:
                accumulate();
                break;
            case 2:
                convert();
                break;
            case 3:
                search();
                break;
            case 4:
                alter();
                break;
            case 5:
                regist();
                break;
            case 6:
                System.out.println("退出系统成功！欢迎下次再来！");
                    System.exit(1);
                break;
            default:
                System.out.println("输入错误！请输入1-7之间的整数！");
                break;

        }
    print();
    }

    //检查登录：输入卡号和密码
    //注意！返回值为Member类对象！
    public Member login(){
        System.out.println("请输入您的会员卡号：");
        int idNo = input.nextInt();
        System.out.println("请输入您的密码：");
        String password = input.next();

        for (Member m : list) {
            if (m.getIdNo()==idNo && m.getPassword().equals(password)){
                return m;
            }
        }
        return null;
    }
    //1、积分累加
    public void accumulate(){
        Member m = login();
        //外层套了一个循环，判定输入的会员卡号和密码，如果错误，循环输入，知道输入正确跳出循环。
        boolean isPsw = false;
        while (!isPsw){
            if (m!=null){
                isPsw = true;
                System.out.println("请输入您的消费金额（一元一积分）：");
                int integral = input.nextInt();
                //根据输入的金额，修改积分
                m.setIntegral(integral+m.getIntegral());
                System.out.println("累计成功！您现有的积分为："+m.getIntegral());

            }else {
                isPsw = false;
                System.out.println("您输入的信息有误，积分累计失败！");
                m = login();
            }
        }
    }

    //2、积分兑换
    public void convert(){
        Member m = login();
        if (m!=null){

            System.out.println("请输入您要兑换的积分，（100积分抵用1元，不足100积分的不作抵用）");
            int integral = input.nextInt();
            if (m.getIntegral()>=100 && integral>=100 &&integral<=m.getIntegral()){
                m.setIntegral(m.getIntegral()-integral);
                System.out.println("您本次抵用的金额为："+integral/100);
                System.out.println("积分兑换成功！"+"您剩余的积分为："+m.getIntegral());
            }else {
                System.out.println("积分兑换失败！账户积分不足，或兑换的积分大于剩余积分！");
            }

        }else {
            System.out.println("您输入的信息有误！无法兑换积分");
        }
    }

    //3、查询剩余积分
    public void search(){
        Member m = login();
        if (m!=null){
            System.out.println("姓名 \t会员卡号 \t积分 \t注册日期 \t");
            System.out.println(m.getName()+"\t"+m.getIdNo()+"\t"+m.getIntegral()+"\t"+m.getRegister());
        }else {
            System.out.println("输入信息有误，请核对后再输！");
        }
    }

    //4、修改密码
    public  void alter(){
        Member m = login();
        if (m!=null){
            System.out.println("请输入您的新密码：");
            String newPsw = input.next();
            m.setPassword(newPsw);
            System.out.println("修改密码成功！");
        }else {
            System.out.println("输入信息有误，请核对后再输！");
        }
    }
    //5、开卡
    public void regist(){
        System.out.println("请输入注册姓名：");
        String name = input.next();
        System.out.println("请输入6位注册密码：");
        String password = input.next();

        //验证密码长度是否等于6位
        boolean isTrue = false;
        while (!isTrue){
            if (password.length()!=6){
                isTrue = false;
                System.out.println("您输入的密码长度小于6位，请重新输入！");
                password = input.next();
            }else {
                isTrue=true;
            }
        }

        //生成一个6位数的随机会员卡号
        Random random = new Random();
        //用StringBuffer的添加功能.append 循环6次，拼接成6个随机数
        StringBuffer sbID = new StringBuffer();
        for (int i = 0; i <6 ; i++) {
            sbID.append(random.nextInt(10));
        }
          String sID =sbID.toString();
        //用Integer.valueOf(String)方法，将String类型的值转换为int类型的值
          int idNo  = Integer.valueOf(sID);
          
        //生成开卡日期
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //把构建的日期赋给定义的属性注册日期register
        String register = formater.format(date);
        System.out.println("开卡时间为："+register);

        //开卡送积分
        int integral=100;
        //把新注册的用户信息添加到列表
        list.add(new Member(name,idNo,password,integral,register));

        System.out.println("恭喜您注册成功，系统送您100积分！您的会员卡号为："+idNo+"\t\t请牢记您的会员卡号和密码！");

    }

}
