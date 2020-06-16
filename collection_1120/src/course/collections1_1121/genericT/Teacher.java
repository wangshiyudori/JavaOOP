package course.collections1_1121.genericT;

public class Teacher {
    private String name;
    private int age;
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Teacher() {
    }

    public Teacher(String  name, int age, int year) {
        this.name = name;
        this.age = age;
        this.year = year;
    }

    public void say(){
        System.out.println("老师说");
    }
}
