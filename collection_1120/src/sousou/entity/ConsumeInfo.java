package sousou.entity;

/*
消费信息
 */
public class ConsumeInfo {
    private String cardNumber;      //卡号
    private String type;            //消费类型：通话、发短信、上网流量
    private int consumeData;        //消费数据：通话--分钟、发短信--条、上网--MB

    public ConsumeInfo() {
    }

    public ConsumeInfo(String cardNumber, String type, int consumeData) {
        this.cardNumber = cardNumber;
        this.type = type;
        this.consumeData = consumeData;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getConsumeData() {
        return consumeData;
    }

    public void setConsumeData(int consumeData) {
        this.consumeData = consumeData;
    }
}
