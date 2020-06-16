package course.thread_1202.Demo1;

//继承Thread： 直接实例化本类对象
public class Test2 {
    public static void main(String[] args) {

        MyThread2 mt1 = new MyThread2("线程A");
        MyThread2 mt2 = new MyThread2("线程B");
        mt1.start();
        mt2.start();

    }
}
