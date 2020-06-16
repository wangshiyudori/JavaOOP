package course.thread_1202.P1;

public class TestP1 {
    public static void main(String[] args) {
        Thread thread0 = new Thread(new P1());
        thread0.setName("thread-0");
        Thread thread1 = new Thread(new P1());
        thread1.setName("thread-1");

        thread0.start();
        thread1.start();

    }
}
