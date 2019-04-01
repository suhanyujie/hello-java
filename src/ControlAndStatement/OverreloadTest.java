package ControlAndStatement;

public class OverreloadTest {
    public static void main(String[] args) {

    }

    public static void testOverreload1(){
        System.out.println("hello ...");
    }

    public static void testOverreload1(String str){
        System.out.println(str);
    }

    public static void testOverreload1(String str1,int i1){
        System.out.println(i1);
    }

    public static void testOverreload1(int i1,String str1){
        System.out.println(i1);
    }
}

/**
 *
## 方法的重载
 * 方法的重载是指一个类中可以定义多个方法名相同，但参数不同的方法。 调用时，会根据不同的参数自动匹配对应的方法。
 *

 ### 重载的2个条件
 * 参数不同：形参类型或形参个数或形参顺序不同
 * 只有返回值不同，是不能构成方法的重载的
 * 只有参数名称不同，不能构成方法的重载
 *



 *
 *
 */
