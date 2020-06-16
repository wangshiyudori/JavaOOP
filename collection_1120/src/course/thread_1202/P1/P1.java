package course.thread_1202.P1;

public class P1 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=20 ; i++) {
            System.out.println(i+"你好，来自线程"+Thread.currentThread().getName());

        }
    }
}
