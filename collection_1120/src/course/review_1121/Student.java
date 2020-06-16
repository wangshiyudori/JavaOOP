package course.review_1121;

/*构造方法：是专门用来创建对象的方法，当我们通过关键字new来创建对象时，其实就是在调用构造方法。
格式：public 类名称（参数类型 参数名称）{
        方法体
}
 */
public class Student {
    private String name;
    private int age;
    public Student(){
        System.out.println("无参构造方法执行了");
    }
    //构造方法的重载
    //有了全参构造方法，调用的时候就不用写set XXX了，
    public Student(String name, int age){
        System.out.println("全参构造方法执行");
        this.name = name;
        this.age =age;
    }

}
