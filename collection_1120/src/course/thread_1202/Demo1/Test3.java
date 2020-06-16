package course.thread_1202.Demo1;

public class Test3 {
    public static void main(String[] args) {
        MyThread3 mt = new MyThread3();
        Thread t = new Thread(mt,"特需（插队的）");

        t.start();


        for (int i = 0; i < 50; i++) {
            System.out.println("Main线程---》"+i );
            if (i==10){
                try {
                    // .join() : 让一个线程强制运行，线程强制运行期间，其他线程无法运行，必须等此线程完成之后，才可以继续执行。
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
