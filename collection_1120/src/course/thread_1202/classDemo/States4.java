package course.thread_1202.classDemo;

public class States4 implements Runnable {
    @Override
    public void run() {
        System.out.println("运行状态");
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println("阻塞状态");
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        System.out.println("死亡状态");
    }
}
