package course.utilityClasses2_1126.stringUser;

public class User {
    private String name;
    private String psd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) throws PwdLengthException{
        if (psd.length()<6){
            throw new PwdLengthException("密码长度至少6位");
        }else {
            this.psd = psd;
        }
    }

    public User() {
    }

    public User(String name, String psd) {
        this.name = name;
        this.psd = psd;
    }

    public boolean login(String _name, String _pwd){
        boolean isLogin = false;
        if (_name.equals(this.name) && _pwd.equals(this.psd)){
            isLogin = true;
        }
        return isLogin;
    }

    public void register(String name, String psd){
        this.setName(name);
        try {
            this.setPsd(psd);
            System.out.println("恭喜你！注册成功");
        } catch (PwdLengthException e) {
            System.out.println("注册失败！");
            System.out.println("原因："+e.getMessage());
        }

    }

}
