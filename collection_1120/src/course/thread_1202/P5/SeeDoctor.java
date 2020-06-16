package course.thread_1202.P5;

public class SeeDoctor implements Runnable {
    private int time;   //看病花费的时间
    private int num;   //看病的数量

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println("正在给第"+(i+1)+"位"+Thread.currentThread().getName()+"看病");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public SeeDoctor() {
    }

    public SeeDoctor(int time, int num) {
        this.time = time;
        this.num = num;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
