package course.threadSafe_1203;

public class TestTicket {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread thread1 = new Thread(t,"黄牛");
        Thread thread2 = new Thread(t,"桃跑跑");
        Thread thread3 = new Thread(t,"猎豹豹");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
