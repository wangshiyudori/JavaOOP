package course.thread_1202.classDemo;

public class Test1 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        thread.setName("abc");
        System.out.println(thread.getName());
    }
}
