package course.utilityClasses2_1126.emailAddress;

public class Email {
    private String EmailAddress;

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) throws EmailFormatException{
        int position1 = emailAddress.indexOf("@");
        int position2 = emailAddress.lastIndexOf(".");
        if (position1<0){
            throw new EmailFormatException("邮件格式不正确，缺少 @");
        }
        if (position2<0){
            throw new EmailFormatException("邮件格式不正确，缺少 .");
        }
        if (position1>position2){
            throw new EmailFormatException("邮件格式不正确，@ 应位于. 前面");
        }
        this.EmailAddress = emailAddress;
        System.out.println("邮箱格式正确。");
    }

    public Email() {
    }

    public Email(String emailAddress) {
        EmailAddress = emailAddress;
    }
}
