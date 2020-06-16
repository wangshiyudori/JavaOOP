package course.thread_1202.synchronize;

public class Ticket implements Runnable {
    private int num = 0;      //出票数
    private int count = 50;    // 剩余票数

    @Override
    public void run() {

        while (true){
            //同步锁代码块
            synchronized (this){
                if (count <=0){
                    break;
                }

                num++;
                count--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票，剩余"+count+"张");
            }
        }
    }
}
