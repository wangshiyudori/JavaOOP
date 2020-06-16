package course.thread_1202.classDemo;

public class MyThread2 extends Thread{

    @Override
    public void run() {
        int sum = 0;
        for (int i = 100; i <=200 ; i++) {
            sum+=i;
            System.out.println(Thread.currentThread().getName()+":"+sum);
        }

    }
}
