package sousou.common;

import java.text.DecimalFormat;

public class Common {
/*
double 类型格式化
 */
    public static String dataFormat(double data){
        DecimalFormat formatData = new DecimalFormat("0.0");
        return formatData.format(data);
    }

    /*
    double 类型两数相减
     */
    public static double sub(double num1,double num2){
        return (num1*10 + num2*10)/10;
    }

}
