package course.utilityClasses1_1125.enumerate;

public class Course {
    private String name;
    private Stage stage;

    public Course() {
    }

    public Course(String name, Stage stage) {
        this.name = name;
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void print(){
        System.out.println("大数据每个单元的学习目标分别是：");
    }
}
