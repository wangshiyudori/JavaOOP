package course.thread_1202.P3;

public class ClimbThread implements Runnable {
    private long time;  //爬山用的时间
    private int num;  //爬李多少次

    public ClimbThread() {
    }

    public ClimbThread(long time, int num) {
        this.time = time;
        this.num = num;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 1; i < num; i ++) {
            try {
                 Thread.sleep(time);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "爬了"+ i*100 + "米");
        }
        System.out.println(Thread.currentThread().getName()+"到达山顶");

    }
}
