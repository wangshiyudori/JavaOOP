package course.thread_1202.P3;

public class TestP3 {
    public static void main(String[] args) {
        ClimbThread c1 = new ClimbThread(300,10);
        ClimbThread c2 = new ClimbThread(500,5);

        Thread thread1 = new Thread(c1);
        thread1.setName("年轻人");
        Thread thread2 = new Thread(c2);
        thread2.setName("老年人");
        thread1.start();
        thread2.start();
    }
}
