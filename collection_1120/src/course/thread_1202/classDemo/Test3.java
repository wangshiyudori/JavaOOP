package course.thread_1202.classDemo;

public class Test3 {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        Thread thread3 = new Thread(myThread3);
        thread3.setName("3333");

        Thread thread4 = new Thread(new MyThread3());
        thread4.setName("4444");

        thread3.start();
        thread4.start();

    }
}
