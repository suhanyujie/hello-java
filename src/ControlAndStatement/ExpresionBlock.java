package ControlAndStatement;

public class ExpresionBlock {
    public static void main(String[] args) {
        testBlock();
    }

    public static void testBlock(){
        int i1 = 2;
        {
            int i2 = 1;
            System.out.println(i2);
        }
        System.out.println(i1);
    }
}

/**
 *
## 语句块
 * 语句块的中声明的变量的作用域只能用于语句块中
 * 方法体中，如果声明了一个变量a，那么在接下来的语句块中，不允许声明同变量名的变量
 * 语句块可以使用外部的变量，而外部不能使用语句块中定义的变量，因为语句块中定义的变量作用域只限于语句块。

 *
 */
