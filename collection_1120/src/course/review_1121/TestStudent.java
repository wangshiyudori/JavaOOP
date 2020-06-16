package course.review_1121;

public class TestStudent {
    public static void main(String[] args) {
        //new 对象就是在调用构造方法 /构造方法就是用来创建对象的
       //没有写参数时，就默认调用无参构造方法了
        Student stu1 = new Student();
        System.out.println("-------------------");
        //写上参数后，虚拟机就会调用全参构造方法了
        Student stu2 = new Student("赵丽颖",20);
    }


}
