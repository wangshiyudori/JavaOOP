package course.thread_1202.classDemo;

public class Test2 {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("thread1");
        MyThread2 myThread2 = new MyThread2();
        myThread2.setName("thread2");

        //启动多线程 start()
        //只有主线程一条执行通道
        myThread1.start();
        myThread2.start();

    }
}
