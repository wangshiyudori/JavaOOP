package course.threadSafe_1203;

public class Ticket implements Runnable {

    private int count = 20;
    private int num = 0;


    @Override
    public void run() {

        while (true) {

            synchronized (this) {

                if (count <= 0) {
                    return;
                }
                num++;
                count--;

                String name = Thread.currentThread().getName();
                if (name.equals("黄牛")) {
                    System.out.println(name + "抢到第" + num + "张票，剩余" + count + "张票");
                    return;
                }
                System.out.println(name + "抢到第" + num + "张票，剩余" + count + "张票");
            }
            //有一部分代码要放在同步代码块外面 保证其他线程可以切进来
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
