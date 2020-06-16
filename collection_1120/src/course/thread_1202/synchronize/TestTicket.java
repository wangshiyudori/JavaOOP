package course.thread_1202.synchronize;

public class TestTicket {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t1 = new Thread(t,"学生");
        Thread t2 = new Thread(t,"工人");
        Thread t3 = new Thread(t,"程序猿");

        t1.start();
        t2.start();
        t3.start();

    }
}
