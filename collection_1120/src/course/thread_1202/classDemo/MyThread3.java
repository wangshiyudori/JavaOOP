package course.thread_1202.classDemo;

public class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread:" + Thread.currentThread().getName() + "-----"+ i);
        }
    }
}

