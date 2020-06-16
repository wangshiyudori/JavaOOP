package course.thread_1202.Demo1;

//2、继承Thread类
public class MyThread2 extends Thread{
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+"运行，i="+i );
        }
    }
}
