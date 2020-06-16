package course.fileAndIO2_1128.serializable1;

public class Cat extends Pet{
    private String brand;

    public Cat() {
    }

    public Cat(String brand) {
        this.brand = brand;
    }

    public Cat(String name, int health, int love, String brand) {
        super(name, health, love);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
