package course.thread_1202.classDemo;

//定义线程 继承Thread
public class MyThread1 extends Thread {
    //重写run方法
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i <=100 ; i++) {
            sum+=i;
            //Thread.currentThread().getName() ： 取得当前线程的名称
            System.out.println(Thread.currentThread().getName()+":"+sum);
        }

    }
}
