package course.threadSafe_1203;

public class RunThread implements Runnable{
    static int num = 1000;
    private String name;

    Object lock = new Object();



    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if (num==0){
                    System.out.println("比赛结束");
                    break;
                }
                name = Thread.currentThread().getName();
                System.out.println(name+"拿到了接力棒！");
                num--;
                for (int i = 0; i <=10 ; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name+"跑了"+(i*10)+"米");

                }
                return;

            }
        }

    }
}
