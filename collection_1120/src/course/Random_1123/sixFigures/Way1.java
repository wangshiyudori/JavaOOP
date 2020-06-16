package course.Random_1123.sixFigures;

//java生成6位随机数的5种方法。
public class Way1 {
    public static void main(String[] args) {
        /*1、用math.random()实现。思路是：math.random()生成的是[0.0, 1.0)的伪随机数，如果 当前值是0.9...，
        则直接*100 0000返回，其他情况可能生成0.03...，0.0003...，这些情况都*100 0000，
        但是结果可能是6位，5位，4位都有可能，那么再加上10 0000，肯定就保证是6位了。*/

        for (int i = 0; i <5; i++) {
            int intFlag =  (int)(Math.random()*1000000);
            //（包装类）valueOf : 基本类型 ---> 包装类 （或 字符串 ---> 包装类）
            String flag = String.valueOf(intFlag);

            //（String类里面里方法）substring : 截取字符串中介于2个指定索引之间的字符
            if (flag.length() == 6 || flag.substring(0,1).equals(9)){
                System.out.println(intFlag);
            }else {
                intFlag = intFlag+100000;
                System.out.println(intFlag);
            }
        }
    }
}

/*  ps: math.random()生成的是个伪随机数，何为伪随机数，这里java是以当前系统时间的相关数字作为种子数，按照特定复杂算法生成的，
其实它生成的大量随机数是线性均匀分布的，黑客是完全可能通过返回的大量随机数结果破解种子数的，所以它并不是真正的随机，叫伪随机数。
   由此我们可以知道通过计算机生成一个真随机数几乎是不可能的，因为最终的输出结果都是依赖算法程序的，这些算法程序本身就是固定的，
我们只能通过更复杂的算法不断优化，让它无限趋近于真随机数，但不绝对。
*/
