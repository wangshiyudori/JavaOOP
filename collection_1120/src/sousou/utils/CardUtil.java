package sousou.utils;

import sousou.common.Common;
import sousou.entity.*;
import sousou.function.CallService;
import sousou.function.NetService;
import sousou.function.SendService;

import java.io.*;
import java.util.*;

/*
手机卡工具类
 */


public class CardUtil {
    Scanner input = new Scanner(System.in);

    //所有手机卡的列表: 卡号，手机卡对象      (Map集合 存储键值对。 <键的对象类型，值的类型>)
    Map<String, MobileCard> cards = new HashMap<>();

    //所有手机卡消费记录的列表：卡号，消费信息
    Map<String, List<ConsumeInfo>> consumeInfos = new HashMap<>();




    //初始化用户
    public void init(){
        MobileCard card1 = new MobileCard("13911111111","aaa","111",
                new TalkPackage(),58.0,42.0);
        MobileCard card2 = new MobileCard("13922222222","bbb","222",
                new NetPackage(),68.0,32.0);
        MobileCard card3 = new MobileCard("13933333333","ccc","333",
                new SuperPackage(),78.0,22.0);

        cards.put("13911111111",card1);
        cards.put("13922222222",card2);
        cards.put("13933333333",card3);
    }

    //使用场景初始化
    List<Scene> scenes = new ArrayList<>();

    public void initScenes(){
        scenes.add(new Scene("通话",90,"问候客户，谁知其如此难缠"));
        scenes.add(new Scene("短信",50,"通知朋友手机换号"));
        scenes.add(new Scene("短信",5,"参与环境保护实施方案问卷调查"));
        scenes.add(new Scene("上网",1*1024,"刷微博2小时"));
    }

    List<ConsumeInfo> infos = new ArrayList<>();
    public void initConsumeInfos(){
        infos.add(new ConsumeInfo("13911111111","tonghua",10));
    }

    /*
    1、用户登录
    是否存在此卡用户： isExistCard（）。
    SCardNumber ：用户输入的卡号
    SPassword  ：用户输入的密码
     */
    public boolean isExistCard(String sNumber, String sPassword){
        //Set<对象类型>
        Set<String> sNumbers = cards.keySet();
        /*
        用迭代器遍历Set数组 Iterator<String>  iterator = mySet.iterator()。
        Iterator接口的方法：
        next()方法：输出Set数组元素，当下一个位置无元素时，就会抛出异常(NoSuchElementException)。
        hasNext()方法：判断下一个位置是否有元素，返回值类型是boolean类型。
         */
        Iterator<String> iterator = sNumbers.iterator();
        while (iterator.hasNext()){
            String searchNum= iterator.next();
            if (searchNum.equals(sNumber) && (cards.get(searchNum)).getPassword().equals(sPassword)){
                return true;
            }
        }

        return false;
    }


    /*
    查找指定卡号是否已注册isRegisterCard().
    二级菜单 4、用到。
     */
    public boolean isRegisterCard(String searchNumber){
        Set<String> numbers= cards.keySet();
        for ( String n: numbers) {
            if (n.equals(searchNumber)){
                return true;
            }

        }
        return false;
    }

    /*
    系统 创建卡号：creatNewNum().
    随机生成以139开头，11位的手机号
     */
    public String creatNewNum(){
        Random random = new Random();
        boolean isExist = false;
        //生成一个8位随机数 初始化
        int eight = 0;
        String newNumber ="";
        do {
            isExist = false;
            do {
                eight = random.nextInt(100000000);
            }while (eight<10000000);
            //新生成的手机号码：139拼接上生成的8位随机数
             newNumber = "139" + eight;
            //和现有的卡号比较 不能重复. 如果重复了 会接着循环执行，直到该卡号不存在
            Set<String> cardNumbers = cards.keySet();
            for ( String cardNumber: cardNumbers) {
                if (newNumber.equals(cardNumber)){
                    isExist = true;
                    break;
                }
            }
        }while (isExist);
        return newNumber;


    }

    /*
    2、（1）用到
    把创建的卡号 生成指定个数的新卡号列表：getNewNumbers().   用于供用户注册新卡时挑选
    指定个数： int count.
     */
    public String[] getNewNumbers(int count){
        String[] numbers = new String[count];
        for (int i = 0; i <count ; i++) {
            numbers[i] = creatNewNum();
        }
        return numbers;
    }

    /*
    2、（3）用到
    根据套餐序号返回套餐对象 : creatPack()
     */
    public ServicePackage creatPack(int packNo){
        ServicePackage pack = null;
        switch (packNo){
            case 1:
                pack = new TalkPackage();
                break;
            case 2:
                pack = new NetPackage();
                break;
            case 3:
                pack = new SuperPackage();
                break;
        }

        return pack;
    }


    /*
    2、（7）用到
    注册完所有信息后 添加新卡
     */
    public void addCard(MobileCard newCard){
        cards.put(newCard.getCardNumber(),newCard);
        System.out.println("注册成功！");
        newCard.showMeg();
    }


    /*
    2、用户注册
     */
    public void registerCard(){
        // （1）显示卡号（提供以“139”开头的9个随机卡号,每行3个）
        String[] newNumbers= getNewNumbers(9);
        System.out.println("可选择的卡号");

        for (int i = 0; i <9 ; i++) {
            System.out.print((i+1)+"."+newNumbers[i]+"\t\t\t");
            if ((i+1)%3 == 0){
                System.out.println();
            }
        }

        // （2）选择卡号
        System.out.println("请您从以下列表中选择您要注册的手机号：（输入1-9的序号）");
        Scanner input = new Scanner(System.in);
        String number = newNumbers[input.nextInt()-1];

        // （3）选择套餐类型
        System.out.println("请选择套餐类型（输入1-3的序号）：1、话唠套餐  2、网虫套餐  3、超人套餐");
        ServicePackage pack= creatPack(input.nextInt()) ;

        // （4）设置用户名
        System.out.println("请输入用户名：");
        String name = input.next();

        // （5）设置密码
        System.out.println("请输入密码：");
        String password = input.next();

        //  （6）输入预存话费金额
        System.out.println("请输入预存话费金额：");
        Double saveMoney = 0.0;
        saveMoney = input.nextDouble();
        while (saveMoney < pack.getPrice()){
            System.out.println("对不起！您预存的话费不足以支付您的月度套餐资费，请重新充值！");
            saveMoney = input.nextDouble();
        }

        //  （7）创建新卡对象并添加   *（？？？？所用套餐输出的是地址指针 ）
        MobileCard newCard = new MobileCard(number,name,password, pack, pack.getPrice(),saveMoney-pack.getPrice());
        addCard(newCard);
    }

    /*
    二级菜单：1、本月账单查询
     */
    public void showAmountDetail(String searchNumber){
        MobileCard card;  //要查询的卡
        StringBuffer meg = new StringBuffer();
        card = cards.get(searchNumber);
        System.out.println("本月账单详情：");
        meg.append("您的卡号："+card.getCardNumber()+"\n");
        meg.append("套餐资费："+card.getSerPackage().getPrice()+"元 \n");
        meg.append("合计："+ Common.dataFormat(card.getConsumeAmount())+"元 \n");
        meg.append("账户余额："+Common.dataFormat(card.getMoney())+"元 \n");
        System.out.println(meg.toString());
    }


    /*
    二级菜单：2、套餐余量查询
     */
    public void showRemainDetail(String searchNumber){
        MobileCard card;    //要查询的卡
        int remainTalkTime;
        int remainSmsCount;
        int remainFlow;
        StringBuffer meg = new StringBuffer();
        card = cards.get(searchNumber);
        meg.append("您的卡号是："+searchNumber);
        System.out.println("套餐内剩余：");
        ServicePackage pack = card.getSerPackage();
        if (pack instanceof TalkPackage){
            TalkPackage cardPack= (TalkPackage)pack;
            remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime() ?
                    cardPack.getTalkTime()-card.getRealTalkTime() : 0;
            meg.append("通话时长："+remainTalkTime+"分钟");

            remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount() ?
                    cardPack.getSmsCount()-card.getRealSMSCount() : 0;
            meg.append("短信条数："+remainSmsCount+" 条");

        }else if (pack instanceof NetPackage){
            NetPackage cardPack = (NetPackage)pack;
            remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow()-card.getRealFlow() : 0;
            meg.append("上网流量："+ Common.dataFormat(remainFlow*1.0/1024)+"GB");

        }else if (pack instanceof SuperPackage){
            SuperPackage cardPack = (SuperPackage)pack;
            remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime() ?
                    cardPack.getTalkTime()-card.getRealTalkTime() : 0;
            meg.append("通话时长："+remainTalkTime+" 分钟");
            remainSmsCount = cardPack.getSMSCount() > card.getRealSMSCount() ?
                    cardPack.getSMSCount() - card.getRealSMSCount() : 0;
            meg.append("短信条数："+remainSmsCount+" 条");
            remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow()-card.getRealFlow() : 0;
            meg.append("上网流量："+Common.dataFormat(remainFlow *1.0/1024)+" GB");

        }
        System.out.println(meg);
    }

    /*
    添加1条指定卡的消费记录
    number: 要添加消费记录的卡
    info：要添加的消费记录
     */
    public void addConsumeInfo(String number, ConsumeInfo info){
        Set<String> numbers = consumeInfos.keySet();
        Iterator<String> it = numbers.iterator();
        List<ConsumeInfo> infos = new ArrayList<>();
        //现有消费列表中是否存在此卡号消费记录
        boolean isExistInfos = false;
        while (it.hasNext()){
            if (it.next().equals(number)){
                //消费集合中已有该卡号的消费记录，则找到该卡号的消费记录集合，添加1条即可。
                infos = consumeInfos.get(number);
                infos.add(info);
                isExistInfos = true;
                System.out.println("已添加1条消费记录");
                break;
            }
        }

        //该集合中没有此卡号消费记录，则添加。
        if (!isExistInfos){
            infos.add(info);
            consumeInfos.put(number,infos);
            System.out.println("之前不存在此卡的消费记录，已添加一条消费记录");
        }

    }


    /*
    二级菜单：3、打印消费详单
     */
    public void printConsumeInfo(String number){

        Writer fileWriter = null;

        try {
            fileWriter = new FileWriter(number+"消费详情.txt");
            Set<String> numbers = consumeInfos.keySet();
            Iterator<String> it = numbers.iterator();
            //   存储指定卡所有的消费记录
            List<ConsumeInfo> infos = new ArrayList<>();
            //现有消费列表中 是否存在此卡号的消费记录
            boolean isExistInfos = false;
            while (it.hasNext()){
                if (it.next().equals(number)){
                    infos = consumeInfos.get(number);
                    isExistInfos = true;
                    break;
                }
            }

            if (isExistInfos ){
                //存在此卡的消费记录，就写入文本
                StringBuffer content = new StringBuffer("************"+number+"消费记录***********");
                content.append("序号\t 类型\t 数据 \t（通话（分钟）/ 上网（MB）/短信（条））");
                for (int i = 0; i < infos.size(); i++) {
                    ConsumeInfo info = infos.get(i);
                    content.append((i+1) +"\t"+info.getType() +"\t"+ info.getConsumeData());
                }
                fileWriter.write(content.toString());
                fileWriter.flush();

                System.out.println("消费记录打印完毕");
            }else {
                System.out.println("对不起！不存在此号码的消费记录，不能打印。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    二级菜单：4、套餐变更
     */
    public void changingPack(String number, int packNum){
        MobileCard card;    //指定的手机卡
        ServicePackage pack;    //要换的套餐
       // packNum = input.nextInt();

        if (isRegisterCard(number)){
            card = cards.get(number);
            switch (packNum){
                case 1:
                    pack = new TalkPackage();
                    break;
                case 2:
                    pack = new NetPackage();
                    break;
                default:
                    pack = new SuperPackage();
                    break;
            }

            if (!(card.getSerPackage().getClass().getName().equals(pack.getClass().getName()))){
                //该卡余额 - 要换的套餐资费
                if (card.getMoney() >= pack.getPrice()){
                    card.setMoney(card.getMoney()-pack.getPrice());
                    //换套餐
                    card.setSerPackage(pack);
                    //当月实际使用数据清零
                    card.setRealTalkTime(0);
                    card.setRealSMSCount(0);
                    card.setRealFlow(0);
                    //当月消费金额设置为新套餐月资费
                    card.setConsumeAmount(pack.getPrice());
                    System.out.println("更换套餐成功！");
                    pack.showInfo();
                }else {
                    System.out.println("对不起！您的余额不足以支付新套餐本月资费，请充值后再办理更换套餐业务！");
                    return;
                }

            } else {
                System.out.println("对不起！您已经是该套餐用户，无需更换！");
            }

        }else {
            System.out.println("对不起！该卡号未注册，不能换套餐！");
        }
    }

    /*
    二级菜单：5、办理退网
     */
    public void delCard(String delNumber){
        if (isRegisterCard(delNumber)){
            cards.remove(delNumber);
            System.out.println("卡号："+delNumber+"办理退网成功！");
        }else {
            System.out.println("对不起！该卡号未注册，不能办理退网！");
        }
    }

    /*
    3、使用嗖嗖
    number : 当前卡号
     */
    public void useSoSo(String number){
        MobileCard card = cards.get(number);    //获取此卡对象
        ServicePackage pack = card.getSerPackage();     //获取此卡所属套餐
        Random random = new Random();
        int ranNum = 0;
        int temp = 0;   //记录各场景中实际消费数据
        do {
            ranNum = random.nextInt(5);     //生成1-5之间的随机数
            Scene scene = scenes.get(ranNum);       //获取该序号所对应的场景
            switch (ranNum){
                //序号为0或1为通话场景
                case 0:
                case 1:
                    //判断该卡所属套餐是否支持通话功能。
                    if (pack instanceof CallService){
                        //执行通话方法
                        System.out.println(scene.getDescription());
                        CallService callService = (CallService)pack;
                        try {
                            temp= callService.call(scene.getData(),card);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //添加一条通话记录
                        addConsumeInfo(number,new ConsumeInfo(number,scene.getType(),temp));
                        break;
                    }else {
                        //如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景
                        continue;
                    }
                //序号为2或3为发短信场景
                case 2:
                case 3:
                    //判断该卡套餐是否支持短信功能
                    if (pack instanceof SendService){
                        //执行发送短信功能
                        System.out.println(scene.getDescription());
                        SendService sendService = (SendService)pack;
                        try {
                            temp= sendService.send(scene.getData(),card);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //添加一条消费记录
                        addConsumeInfo(number,new ConsumeInfo(number,scene.getType(),temp));
                        break;
                    }else {
                        continue;
                    }
                //序号4或5为发上网场景
                case 4:
                case 5:
                    if (pack instanceof NetService){
                        System.out.println(scene.getDescription());
                        NetService netService= (NetService)pack;
                        //这里怎么没有产生异常
                        temp= netService.netPlay(scene.getData(),card);

                        addConsumeInfo(number,new ConsumeInfo(number,scene.getType(),temp));
                        break;
                    }else {
                        continue;
                    }

            }
            break;
        }while (true);
    }

    /*
    4、话费充值
    number: 指定充值的卡号
    money: 充值的金额
     */
    public void chargeMoney(String number, double money){
        MobileCard card;   //指定的手机卡
        do {
            System.out.println("对不起！最低充值金额为50元");
        }while (money<50);

        card= cards.get(number);
        card.setMoney(card.getMoney()+money);
        System.out.println("充值成功！当前话费余额为："+Common.dataFormat(card.getMoney()) +"元" );
    }

/*
5、显示资费说明 （？？ 这里为什么不用传手机号的参数）
 */
    public void showDescription(){
        try {
            Reader reader = new FileReader("套餐资费说明.txt");
            char[] content = new char[1024];
            int len = 0;
            StringBuffer sb = new StringBuffer();
            while ( (len = reader.read(content))!= -1 ){
                sb.append(content,0,len);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}






