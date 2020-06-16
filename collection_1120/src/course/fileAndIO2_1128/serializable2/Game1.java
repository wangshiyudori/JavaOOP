package course.fileAndIO2_1128.serializable2;

import java.io.Serializable;

public class Game1 implements Serializable {

    private String name;

    public Game1(String name) {
        this.name = name;
    }
    //私有化基地类 并 定义变量
    private Jidi1 red;
    private Jidi1 blue;

    public Jidi1 getRed() {
        return red;
    }

    public void setRed(Jidi1 red) {
        this.red = red;
    }

    public Jidi1 getBlue() {
        return blue;
    }

    public void setBlue(Jidi1 blue) {
        this.blue = blue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //定义方法
    public void init(){
        red = new Jidi1("红方");
        blue = new Jidi1("蓝方");
    }

}
