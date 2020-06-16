package sousou.entity;

/*
移动卡类
 */
public class MobileCard {
    private String cardNumber;                  //卡号
    private String userName;                    //用户名
    private String password;                    //密码
    private ServicePackage serPackage;          //移动卡所属套餐
    private double consumeAmount;               //本月消费金额
    private double money;                     //本月余额
    private int realTalkTime;                   //本月实际通话时长
    private int realSMSCount;                   //本月实际发送短信条数
    private int realFlow;                       //本月实际上网流量

    public MobileCard() {
    }

    //接收新注册用户的 卡号、用户名、密码
    public MobileCard(String cardNumber, String userName, String password) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.password = password;
    }

    //用于初始化用户 和 接收新注册的用户
    public MobileCard(String cardNumber, String userName, String password,
                      ServicePackage serPackage, double consumeAmount, double money) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.password = password;
        this.serPackage = serPackage;
        this.consumeAmount = consumeAmount;
        this.money = money;
    }

    public MobileCard(String cardNumber, String userName, String password, ServicePackage serPackage,
                      double consumeAmount, double balance, int realTalkTime, int realSMSCount, int realFlow) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.password = password;
        this.serPackage = serPackage;
        this.consumeAmount = consumeAmount;
        this.money = money;
        this.realTalkTime = realTalkTime;
        this.realSMSCount = realSMSCount;
        this.realFlow = realFlow;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ServicePackage getSerPackage() {
        return serPackage;
    }

    public void setSerPackage(ServicePackage serPackage) {
        this.serPackage = serPackage;
    }

    public double getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(double consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMSCount() {
        return realSMSCount;
    }

    public void setRealSMSCount(int realSMSCount) {
        this.realSMSCount = realSMSCount;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }

    //显示移动卡的信息
    public void showMeg(){
        System.out.println("卡号："+this.cardNumber+"用户名："+this.userName+"所用套餐："
                +this.serPackage+"当前余额："+this.money);
        this.serPackage.showInfo();
    }
}
