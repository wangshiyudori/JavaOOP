package course.thread_1202.Demo1;

//Runnable接口： 要先实例化本类对象，再实例化Thread类对象
public class Test1 {
    public static void main(String[] args) {
        //实例化对象
        MyThread1 mt1 = new MyThread1("线程A");
        MyThread1 mt2 = new MyThread1("线程B");
        //实例化Thread类对象
        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt2);
        //启动多线程
        t1.start();
        t2.start();

    }
}
