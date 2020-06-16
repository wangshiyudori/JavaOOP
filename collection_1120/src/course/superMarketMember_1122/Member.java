package course.superMarketMember_1122;

public class Member {
    private String name;
    private int idNo;  //会员卡号
    private String password;
    private int integral;  //积分
    private String register;  //注册日期

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Member() {
    }

    public Member(String name, int idNo, String password, int integral, String register) {
        this.name = name;
        this.idNo = idNo;
        this.password = password;
        this.integral = integral;
        this.register = register;
    }
}
