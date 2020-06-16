package sousou.business;

import sousou.utils.CardUtil;

import java.util.Scanner;

public class SouSystem {
    Scanner input = new Scanner(System.in);
    CardUtil utils = new CardUtil();
/*
主流程
 */
    public void mainMenu(){
        String mobileNumber = "";
        String password ="";
        //调用初始化的用户
        utils.init();
        //调用初始化的场景
        utils.initScenes();
        int mainChoose = 0;
        utils.initConsumeInfos();


        do {
            System.out.println("*****************欢迎使用嗖嗖移动业务大厅******************");
            System.out.println("1、用户登录  2、用户注册   3、使用嗖嗖   4、话费充值    5、资费说明    6、退出系统");
            System.out.println("请选择：");
            mainChoose =  input.nextInt();

            switch (mainChoose){

                case 1:
                    //1、用户登录
                    System.out.println("请输入手机号：");
                    mobileNumber =input.next();
                    System.out.println("请输入密码：");
                    password = input.next();
                    if (utils.isExistCard(mobileNumber,password)){
                        cardMenu(mobileNumber);
                    }else {
                        System.out.println("对不起！您输入的信息有误，请核对后再输！");
                    }
                    break;
                case 2:
                    System.out.println("**************用户注册*************");
                    utils.registerCard();
                    break;
                case 3:
                    System.out.println("****************使用嗖嗖*****************");
                    System.out.println("请输入您的手机号：");
                    mobileNumber = input.next();
                    if (utils.isRegisterCard(mobileNumber)){
                        /*
                        System.out.println("使用之前：")
                        utils.showRemainDetail(mobileNumber);
                        utils.showAmountDetail(mobileNumber);
                         */
                        utils.useSoSo(mobileNumber);
                    }else {
                        System.out.println("对不起！该卡号未注册。");
                    }
                    /*System.out.println("使用之后：");
                    utils.showRemainDetail(mobileNumber);
                    utils.showAmountDetail(mobileNumber);
                     */
                    break;
                case 4:
                    System.out.println("*****************话费充值*****************");
                    System.out.println("请输入充值卡号：");
                    mobileNumber = input.next();
                    if (utils.isRegisterCard(mobileNumber)){
                        System.out.println("请输入充值金额：");
                        double money = input.nextDouble();
                        utils.chargeMoney(mobileNumber,money);
                    }else {
                        System.out.println("对不起！该卡号不存在");
                    }
                    break;
                case 5:
                    System.out.println("*******************资费说明********************");
                    utils.showDescription();
                    break;
                case 6:
                    System.out.println("******************退出系统*****************");
                    break;
                default:
                    //选择其他数字退出系统
                    break;
            }

        }while (true);
    }

    /*
    （主菜单选择1、用户登录 登录成功以后进入二级菜单）
    手机卡功能菜单：
     */

    public int cardMenu(String mobileNumber){
        //初始化二级菜单选项subChoose
        int subChoose = 0;

        do {
            System.out.println("******************嗖嗖移动用户菜单***************");
            System.out.println("1、本月账单查询   2、套餐余量查询   3、打印消费详单   4、套餐变更   5、办理退网");
            System.out.println("请选择（输入1-5选择功能，其他键返回上一级）：");
            subChoose= input.nextInt();

            switch (subChoose){
                case 1:
                    System.out.println("*************本月账单查询**************");
                    utils.showAmountDetail(mobileNumber);
                    break;
                case 2:
                    System.out.println("***********套餐余量查询**************");
                    utils.showRemainDetail(mobileNumber);
                    break;
                case 3:
                    System.out.println("*************打印消费详单*************");
                    utils.printConsumeInfo(mobileNumber);
                    break;
                case 4:
                    System.out.println("************套餐变更******************");
                    System.out.println("请选择要变更的套餐（1-3）：1、话唠套餐  2、网虫套餐  3、超人套餐");
                    utils.changingPack(mobileNumber,input.nextInt());
                    break;
                case 5:
                    System.out.println("***************办理退网**************");
                    utils.delCard(mobileNumber);
                    System.out.println("谢谢使用！");
                    System.exit(1);     //办理退网后退出系统。
                    break;
            }

            break;
        }while (true);

        return subChoose;

    }













}


