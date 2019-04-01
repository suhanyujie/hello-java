package identifier;

public class TypeCovert {
    public static void main(String[] args) {
//        typeContert();
        overflowQue1();
    }


    /**
     * 溢出问题
     */
    public static void overflowQue1(){
        // 当2个int数运算后超出int的表示范围后，此时，如果赋值给int或者long，还是会溢出
        // 正确的做法是，运算的表达式中，将其中一个变量类型强制转为long
        long i = (long)2011 * 2100000000;
        System.out.println(i);
    }

    /**
     * 类型的自动转换
     * 容量小的类型变量可以转换为容量大的类型变量
     */
    public static void typeContert(){
        int i1 = 1000;
        long l1 = i1;
        System.out.println(l1);
        // 特例  int 到 byte的转换，因为数字尚在byte可表示的范围之内
        byte b1 = 126;
        System.out.println(b1);
        // 整形到char的强制转换
        int a1 = 98;
        System.out.println((char)a1);
    }
}
