package identifier;

public class type1 {
    public static void main(String[] args) {
//        scaleType();
//        float1();
//        charType();
//        operatorType();
//        opLogic();
//        strConcat();
        opPriority();
    }

    /**
     * 运算符优先级
     */
    public static void opPriority(){
        // 括号 > (一元运算符 递增 递减 ) > (算术运算符 左移 右移) > 关系运算符 > (位运算符 逻辑运算符& | ^) > (逻辑运算符&& || ?:) > (赋值运算符 扩展运算符)
        // 其中要注意：逻辑非 > 逻辑与 > 逻辑或
        int i1 = 2 >> 1 + 1;// 算数运算符Priority高，所以先计算1+1
        System.out.println(i1);
        // 关系运算符priority低，所以先计算i1+4，然后再进行比较！
        boolean b1 = i1 + 4 > 4;
        System.out.println(b1==false);
    }

    /**
     * 字符串连接操作符
     */
    public static void strConcat(){
        // 只要`+`左边或右边，有字符串类型，此时`+`所表达的意思就是字符串连接操作符
        int i1 = 123123123;
        System.out.println(""+i1);
    }

    /**
     * 逻辑运算符
     */
    public static void opLogic(){
        boolean b1,b2,bres;

        // 左移运算符 左移一位相当于乘2；右移一位相当于除以2
        int i1 = 2;
        i1 = i1 << 3;// 2*2E3
        System.out.println(i1);

        // 字符串运算符
        // 如果+左右两边，只要有字符类型，此时`+`就是字符串连接符，否则就是运算符
        i1 = 123;
        System.out.println(""+i1);

        // 或运算符
        b1 = true;
        b2 = false;
        System.out.println(b1 | b2);
        // 与运算符
        b1 = true;
        b2 = false;
        System.out.println(b1 & b2);
        //异或运算符
        b1 = true;
        b2 = false;
        bres = b1 ^ b2;
        System.out.println(bres);
    }

    public static void operatorType(){
        int i1 = 12;
        i1 *= 1+2;//这种扩展的运算符，始终先算1+2，然后再计算‘相乘’号，也就是相当于`i1 * (1+2)`
        System.out.println(i1);
    }

    public static void charType() {
        char a = 'a';
        char a1 = 'b';

        System.out.println(a);
        // 字符相加 会产生类型转换，如果要打印字符串，可以加一个双引号转换
        System.out.println(a + a1);
        System.out.println("" + a + a1);
        // 打印unicode字符集中的字符
        System.out.println('\u0061');
    }

    /**
     * 浮点数是不精确的，不要用于进行比较，如果要比较，可以使用math包中的方法
     */
    public static void float1() {
        float f1 = 3.14f;
        double f2 = 3.14;
        System.out.println(f1 == f2);
    }

    /**
     * 进制数表示
     */
    public static void scaleType() {
        int i1 = 01;
        int i2 = 0xA;
        int i3 = 0b100011;
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
    }
}

/**
 * ## 进制数表示
 * 2进制：`0b`开头
 * 8进制：`0`开头
 * 10进制：正常书写
 * 16进制：`0x`开头
 * 具体表示可以查看上方的`scaleType`方法
 */
