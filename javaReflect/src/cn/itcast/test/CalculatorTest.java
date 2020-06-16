package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    /**
     * 初始化方法：
     * 用于资源的申请，所有测试方法执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源的方法：
     * 在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close....");
    }


    @Test
    public void testAdd(){
        System.out.println("testAdd(验证@Before，@close)");
        //System.out.println("我被执行了！");
        //1、创建计算器对象
        Calculator c = new Calculator();
        //2、调用add方法
        int add = c.add(3, 3);
        //一般不用输出来测试程序写得对不对，因为在add方法里如果定义的不符合逻辑是检测不出来的
//        System.out.println(add);
        //3、断言 期望的结果和实际结果进行比较，已验证程序
        Assert.assertEquals(6,add);
    }

    @Test
    public void sub(){
        Calculator c = new Calculator();
        int sub = c.sub(4, 2);
        Assert.assertEquals(2,sub);
        System.out.println("testAdd(验证@Before，@close)");
    }
}
