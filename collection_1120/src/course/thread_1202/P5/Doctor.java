package course.thread_1202.P5;

//创建一个线程类SeeDoctor，用来实现特需病人，优先等级最高。把main方法的主线程取名为普通病人。
public class Doctor {
    public static void main(String[] args) throws InterruptedException {
        SeeDoctor sd = new SeeDoctor(300,10);
        Thread t = new Thread(sd,"特需病人");
        Thread.currentThread().setName("普通病人");

        t.start();
        t.setPriority(10);
        for (int i = 0; i <50 ; i++) {

            System.out.println("正在给第"+(i+1)+"位"+Thread.currentThread().getName()+"看病");
                Thread.sleep(150);
            if (i==9){
                t.join();
            }
        }


    }
}
