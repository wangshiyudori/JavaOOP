package course.utilityClasses2_1126.stringP1;
/*
实现会员注册，要求：
        用户名长度不小于3
        密码长度不小于6
        注册时两次输入密码
        必须相同
*/

public class Member {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws UserNameLengthException{
        if (userName.length()<3){
            throw new UserNameLengthException("用户名长度不能小于3");
        }else{
            this.userName = userName;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordLengthException{
        if (password.length()<6){
           throw new PasswordLengthException("密码长度不小于6位");
        }else {
            this.password = password;
        }
    }

    public Member() {
    }

    public Member(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public void register(String userName, String password){
        try {
            this.setUserName(userName);

        } catch (UserNameLengthException e) {
            System.out.println("注册失败!");
            System.out.println("原因："+e.getMessage());
        }
        try {
            this.setPassword(password);
        } catch (PasswordLengthException e) {
            System.out.println("注册失败！");
            System.out.println("原因："+e.getMessage());
        }
    }

    public boolean isEqual(String password1, String password2){
        boolean isEqual = false;
        if ( password1.equals(password2)) {
            isEqual = true;
            System.out.println("注册成功！");
        }else {
            System.out.println("密码验证错误！");
        }
        return isEqual;
    }
}
