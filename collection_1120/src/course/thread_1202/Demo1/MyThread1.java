package course.thread_1202.Demo1;

/*
在Java中实现多线程有两种方法，1是实现Runnable接口，2是继承Thread类。
(实际上Thread类和Runnable接口之间在使用上也是有区别的，如果一个类继承Thread类，则不适合于多个线程共享资源，
而实现了Runnable接口，就可以方便的实现资源的共享。)
 */

//1、 实现Runnable接口
public class MyThread1 implements Runnable {
    //表示线程的名称
    private String name;

    //通过构造方法配置name属性
    public MyThread1(String name) {
        this.name = name;
    }

    //覆盖重写run方法，作为线程的操作主体
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(name+"运行，i="+i);
        }
    }
}
