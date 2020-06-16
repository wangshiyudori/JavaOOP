package course.collections1_1121.Demo;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private int salary;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Person() {
    }

    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Person o) {
//        this.getName().compareTo(o.getName());

        if (this.getAge()!= o.getAge()){
            return this.getAge()-o.getAge();
        }else {
            return this.getSalary()-o.getSalary();
        }
    }
}
