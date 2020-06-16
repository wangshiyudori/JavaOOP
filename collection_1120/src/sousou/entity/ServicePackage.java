package sousou.entity;

/*
3个移动套餐-----父类
 */
public abstract class ServicePackage {
    //3个套餐的共同属性：每月交月租
    protected double price;           //月租

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //显示套餐内容，3个套餐子类会用
    public abstract void showInfo();
}
