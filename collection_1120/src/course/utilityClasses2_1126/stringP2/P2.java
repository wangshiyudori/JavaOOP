package course.utilityClasses2_1126.stringP2;

//查找特定字符出现的次数
public class P2 {
    public static void main(String[] args) {
        String string = new String("我爱爸爸妈妈，我爱猫，我爱钱吼吼");
        int i = 0;
        int count = 0;

//方式一： 用while循环
//        while (i != -1){
//            i = string.indexOf("爱",i);
//            if (i>= 0){
//                count++;
//                i++;
//            }
//        }
//        System.out.println("爱 出现的次数为："+count);

        //方式二：用for循环
        for (int j = 0; j < string.length()-1; j++) {
            if ("爱".equals(string.substring(j,j+1))){
                count++;
            }
        }
        System.out.println("爱 出现的次数为："+count);
    }
}
