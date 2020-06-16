package course.thread_1202.Demo1;

public class MyThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            //取得当前线程的名字
            System.out.println(Thread.currentThread().getName()+"运行，i="+i);
        }
    }
}
