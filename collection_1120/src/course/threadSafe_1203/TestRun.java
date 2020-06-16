package course.threadSafe_1203;

public class TestRun {
    public static void main(String[] args) {

        RunThread rt = new RunThread();
        Thread thread1 = new Thread(rt,"1号选手");
        Thread thread2 = new Thread(rt,"2号选手");
        Thread thread3 = new Thread(rt,"3号选手");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
